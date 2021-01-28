package com.esisa.jee.daoo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class MYSQLDataSource extends DataSource {
	
	public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	public static final String MYSQL_BRIDGE = "jdbc:mysql:"; 

	
	public MYSQLDataSource(String host, String source, String userName, String password) {
		super(MYSQL_DRIVER,MYSQL_BRIDGE + "//" + host + "/" + source , userName, password);
	}
	
	public MYSQLDataSource(String source, String userName, String password) {
		super(MYSQL_DRIVER,MYSQL_BRIDGE + "//localhost/" + source , userName, password);
	}
	
	public MYSQLDataSource(String source, String userName) {
		super(MYSQL_DRIVER,MYSQL_BRIDGE + "//localhost/" + source , userName, "");
	}
	
	public MYSQLDataSource(String source) {
		super(MYSQL_DRIVER,MYSQL_BRIDGE + "//localhost/" + source , "root", "");
	}
	
	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		try
		{
			//1. Chargement du Driver:
			Class.forName(MYSQL_DRIVER);
		
			//2.Connexion:
			Connection db = DriverManager.getConnection(getUrl(), getUser(), getPassword());
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
