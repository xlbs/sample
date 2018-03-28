package com.huayun.sample.common;

public class DataSourceConstants {
	
	//南厂房数据库 north plant
	public final static String NORTH_SCAN_PACKAGE="com.huayun.sample.north.dao";
	public final static String NORTH_SCAN_MAPPER="classpath:/mybatis-mapper/north/**/*.xml";
	public final static String NORTH_SESSION_FACTORY="NorthSQLSessionFactory";
	public final static String NORTH_DATA_SOURCE="NorthSQLDataSource";
	public final static String NORTH_TX_MG="NorthSQLTransactionManager";
	//北厂房数据库 south plant
	public final static String SOUTH_SCAN_PACKAGE="com.huayun.sample.south.dao";
	public final static String SOUTH_SCAN_MAPPER="classpath:/mybatis-mapper/south/**/*.xml";
	public final static String SOUTH_SESSION_FACTORY="SouthSQLSessionFactory";
	public final static String SOUTH_DATA_SOURCE="SouthSQLDataSource";
	public final static String SOUTH_TX_MG="SouthSQLTransactionManager";

}
