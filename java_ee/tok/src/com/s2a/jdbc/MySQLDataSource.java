package com.s2a.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLDataSource extends DataSource
{

	public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	public static final String MYSQL_BRIDGE = "jdbc:mysql:";
	
	public MySQLDataSource(String host,String source,String user , String password) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE +"//" +host + "/"+ source, user, password);
	}
	
	public MySQLDataSource(String source,String user , String password) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE +"//localhost/"+ source, user, password);
	}
	public MySQLDataSource(String source,String user) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE +"//localhost/"+ source, user,"");
	}
	public MySQLDataSource(String source) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE +"//localhost/"+ source, "root", "");
	}
	
	
	@Override
	public Connection getConnection() 
	{
		try
		{
		//1. Chargement du Driver:
		Class.forName(MYSQL_DRIVER);
		
		//2.Connexion:
		
		Connection db = DriverManager.getConnection(getUrl() , getUser() , getPassword());
		System.out.println("Connexion bien etablie");
		return db;
		
		}
		
		catch (Exception e)
		{
			System.out.println("Erreur : " + e.getMessage());
			return null;
		}
	}

}
