package com.esisa.jee.jdbc;

import java.sql.Connection;

abstract public class DataSource {
	private String driver;
	private String url;
	private String user;
	private String password;
	
	
	public DataSource() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DataSource(String driver, String url, String user, String password) {
		super();
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
	}


	public String getDriver() {
		return driver;
	}


	public void setDriver(String driver) {
		this.driver = driver;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	abstract public Connection getConnection();

}
