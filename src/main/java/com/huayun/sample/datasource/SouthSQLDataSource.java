package com.huayun.sample.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;



import com.alibaba.druid.pool.DruidDataSource;

@Configuration
//扫描base dao接口包名
@MapperScan(basePackages = DataSourceConstants.SOUTH_SCAN_PACKAGE, sqlSessionFactoryRef = DataSourceConstants.SOUTH_SESSION_FACTORY)
public class SouthSQLDataSource {

    @Value("${south.datasource.url}")
    private String dbUrl;
    @Value("${south.datasource.username}")
    private String dbUser;
    @Value("${south.datasource.password}")
    private String dbPassword;
    
    @Qualifier(DataSourceConstants.SOUTH_DATA_SOURCE) 
    @Bean(name = DataSourceConstants.SOUTH_DATA_SOURCE)
    public DataSource initMmsDataSource() {
    	DruidDataSource dataSource = new DruidDataSource();
    	dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUser);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

    @Bean(name =DataSourceConstants.SOUTH_TX_MG)
    public DataSourceTransactionManager initFtpTransactionManager(@Qualifier(DataSourceConstants.SOUTH_DATA_SOURCE) DataSource southDataSource) {
        return new DataSourceTransactionManager(southDataSource);
    }

    @Bean(name = DataSourceConstants.SOUTH_SESSION_FACTORY)
    public SqlSessionFactory initMmsSessionFactory(@Qualifier(DataSourceConstants.SOUTH_DATA_SOURCE) DataSource southDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(southDataSource);
        //绑定north mybatis映射文件路径
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DataSourceConstants.SOUTH_SCAN_MAPPER));
        return sessionFactory.getObject();
    }
}
