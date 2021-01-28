package com.esisa.jee.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class MYSQLDataSource extends DataSource{
	public static final String MYSQL_DRIVER= "com.mysql.jdbc.Driver";
	public static final String MYSQL_BRIDGE = "jdbc:mysql:";
	
	public MYSQLDataSource(String host,String source, String userName, String password) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE +"//" +host +"/"+source,userName,password);
	}
	
	public MYSQLDataSource(String source, String userName, String password) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE +"//localhost/"+source,userName,password);
	}
	
	public MYSQLDataSource(String source, String userName) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE +"//localhost/"+source,userName,"");
	}

	
	public MYSQLDataSource(String source) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE +"//localhost/"+source,"root","");
	}
	
	
	public Connection getConnection() {
		try {
			//1ere etape : charger le driver
			Class.forName(MYSQL_DRIVER);
		
			//3eme etape : connection 
			Connection db= DriverManager.getConnection(getUrl(), getUser(), getPassword());
			
			System.out.println("Connexion bien établie...");
			return db;
		} catch (Exception e) {
			System.out.println("Erreur :" + e.getMessage());
			return null;
		}
	}
	
	
	
}
