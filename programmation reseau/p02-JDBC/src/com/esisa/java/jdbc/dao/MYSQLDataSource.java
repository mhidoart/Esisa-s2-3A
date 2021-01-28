package com.esisa.java.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MYSQLDataSource extends DataSource {
	public static final String MYSQL_DRIVER ="com.mysql.jdbc.Driver";
	public static final String MYSQL_BRIDGE="jdbc:mysql:";
	public MYSQLDataSource(String host,String source,String Username,String password) {
		super(MYSQL_DRIVER,MYSQL_BRIDGE+"//" + host + "/" + source, Username, password);
	}
	public MYSQLDataSource(String source,String Username,String password) {
		super(MYSQL_DRIVER,MYSQL_BRIDGE+"//localhost/" + source, Username, password);
	}
	public MYSQLDataSource(String source,String Username) {
		super(MYSQL_DRIVER,MYSQL_BRIDGE+"//localhost/" + source, Username, "");
	}
	public MYSQLDataSource(String source ) {
		super(MYSQL_DRIVER,MYSQL_BRIDGE+"//localhost/" + source, "root", "");
	}
	

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		try {
			//1-charger les drivers
			Class.forName(MYSQL_DRIVER);
			//2-construction de l'URL
		
			//3-connection
			Connection db=DriverManager.getConnection(getUrl(), getUser(),getPassword());
			System.out.println("connection bien etablie .......!");
			return db;
		} catch (Exception e) {
			System.out.println("erreur : " + e.getMessage());
			return null;
		}
		
	}

}
