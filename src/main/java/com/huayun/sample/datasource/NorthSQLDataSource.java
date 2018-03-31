package com.huayun.sample.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
//扫描base dao接口包名
@MapperScan(basePackages = DataSourceConstants.NORTH_SCAN_PACKAGE, sqlSessionFactoryRef = DataSourceConstants.NORTH_SESSION_FACTORY)
public class NorthSQLDataSource {

    @Value("${north.datasource.url}")
    private String dbUrl;
    @Value("${north.datasource.username}")
    private String dbUser;
    @Value("${north.datasource.password}")
    private String dbPassword;
    
    @Qualifier(DataSourceConstants.NORTH_DATA_SOURCE) 
    @Bean(name = DataSourceConstants.NORTH_DATA_SOURCE)
    @Primary //必须指定一个默认数据源（主数据源）
    public DataSource initMmsDataSource() {
    	DruidDataSource dataSource = new DruidDataSource();
    	dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUser);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

    @Bean(name =DataSourceConstants.NORTH_TX_MG)
    @Primary //必须指定一个默认数据源（主数据源）
    public DataSourceTransactionManager initFtpTransactionManager(@Qualifier(DataSourceConstants.NORTH_DATA_SOURCE) DataSource northDataSource) {
        return new DataSourceTransactionManager(northDataSource);
    }

    @Bean(name = DataSourceConstants.NORTH_SESSION_FACTORY)
    @Primary //必须指定一个默认数据源（主数据源）
    public SqlSessionFactory initMmsSessionFactory(@Qualifier(DataSourceConstants.NORTH_DATA_SOURCE) DataSource northDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(northDataSource);
        //绑定north mybatis映射文件路径
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DataSourceConstants.NORTH_SCAN_MAPPER));
        return sessionFactory.getObject();
    }
}
