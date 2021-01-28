package com.esisa.jee.jdbc;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Connection;

public class Database {
	private DataSource ds;
	private Connection db; //recupere le resultat
	
	
	public Database() {
		
	}
	
	public Database(DataSource ds) {
		this.ds=ds;
		db=ds.getConnection();
	}

	public DataSource getDataSource() {
		return ds;
	}

	public void setDataSource(DataSource ds) {
		this.ds=ds;
		db=ds.getConnection();
	}
	
	public void select()
	{
		String request="SELECT *FROM Authors WHERE Year_Born >0";
		try {
			Statement slq=db.createStatement();		
			ResultSet rs= slq.executeQuery(request);
			while (rs.next()) {
				System.out.println(rs.getString(2)); 
			}
		} catch (Exception e) {
			System.out.println("Erreur : "+e.getMessage());
		}
		
	}
	
	/*public String[][] select(String tableName)
	{
		String request="SELECT *FROM " + tableName;
		try {
			Statement sql=db.createStatement();		
			ResultSet rs= sql.executeQuery(request);
			ResultSetMetaData rsm=rs.getMetaData();
			int n =rsm.getColumnCount();
			rs.last();
			int m=rs.getRow();
			
			String data[][]= new String[m+1][n];
			for (int i = 0; i < n; i++) {
				data[0][i]=rsm.getColumnName(i+1);
			}
			rs.beforeFirst();
			int row =0;
			while (rs.next()) {
				row++;
				for (int i = 0; i < n; i++) {
					data[row][i]= rs.getString(i+1);
				}
			}
			return data; 
		} catch (Exception e) {
			System.out.println("Erreur : "+e.getMessage());
			return null;
		}
		
	}*/
	
	public String[][] executeQuery(String request)
	{
		
		try {
			Statement sql=db.createStatement();		
			ResultSet rs= sql.executeQuery(request);
			ResultSetMetaData rsm=rs.getMetaData();
			int n =rsm.getColumnCount();
			rs.last();
			int m=rs.getRow();
			
			String data[][]= new String[m+1][n];
			for (int i = 0; i < n; i++) {
				data[0][i]=rsm.getColumnName(i+1);
			}
			rs.beforeFirst();
			int row =0;
			while (rs.next()) {
				row++;
				for (int i = 0; i < n; i++) {
					data[row][i]= rs.getString(i+1);
				}
			}
			return data; 
		} catch (Exception e) {
			System.out.println("Erreur : "+e.getMessage());
			return null;
		}
		
	}
	
	public String[][] select(String tableName)
	{
		String request = "SELECT * FROM " + tableName;
		return executeQuery(request);
	}
	
	
	
	public String[][] select(String tableName, String key, Object value)
	{
		String request="SELECT *FROM " + tableName + "WHERE " + key + "='" + value + "'";
		
		return executeQuery(request);
	}
	
	public String[][] selectLike(String tableName, String key, Object value)
	{
		String request="SELECT *FROM " + tableName + "WHERE " + key + " like '%" + value + "%'";
		
		return executeQuery(request);
	}
	
	public boolean insert(String tableName,Object ...row)
	{
		try {
			String request="INSERT INTO " + tableName + " VALUES('" +row[0] +"'";
			
			for (int i = 1; i < row.length; i++) {
				request = request + ", '" + row[i] +"'";
			}
			request = request +")";
			
			Statement sql = db.createStatement();
			if(sql.executeUpdate(request) == 1)
			{
				return true;
			}
			else
					return false;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean delete(String tableName, String key, Object value)
	{
		try {
			String request="DELETE FROM " + tableName +
					" WHERE" +key +" = '" + value + "'";
			
		
			
			Statement sql = db.createStatement();
			if(sql.executeUpdate(request) == 1)
			{
				return true;
			}
			else
					return false;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;
		}
	}
}