package com.esisa.java.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import com.esisa.stock.models.Produit;
import com.mysql.jdbc.ResultSet;


public class Database {
	private DataSource ds;
	private Connection db;
	public Database(DataSource ds) {
		// TODO Auto-generated constructor stub
		this.ds=ds;
		db=ds.getConnection();
	}
	public DataSource getDataSource() {
		return ds;
	}
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	/*
	public Database(String host,String source,String user,String password) {
		try {
			//1-charger les drivers
			Class.forName(driver);
			//2-construction de l'URL
			String url=bridge + "//" +host +"/" + source;
			//3-connection
			db=DriverManager.getConnection(url, user,password);
			System.out.println("connection bien etablie .......!");

			//select();

		} catch (Exception e) {
			System.out.println("erreur : " + e.getMessage());
		}
	}
	 */
	public void select() {
		String request="SELECT * FROM authors WHERE year_born > 0";
		try {
			Statement sql =db.createStatement();
			java.sql.ResultSet rs =sql.executeQuery(request);
			while (rs.next()) {
				System.out.println(rs.getString(2));
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erreur : " + e.getMessage());
		}

	}
	public String[][] select(String tableName) {
		String request="SELECT * FROM "+ tableName;
		return executeQuery(request);

	}
	public String[][] executeQuery(String request) {
		try {
			Statement sql =db.createStatement();
			java.sql.ResultSet rs =sql.executeQuery(request);
			ResultSetMetaData rsm=rs.getMetaData();
			int n = rsm.getColumnCount();
			rs.last();
			int m=rs.getRow();
			String data[][]= new String[m+1][n];
			for (int i = 0; i < n; i++) {
				data[0][i]=rsm.getColumnName(i+1);
			}
			rs.beforeFirst();
			int row=0;
			while (rs.next()) {
				row++;
				for (int i = 0; i < n; i++) {
					data[row][i]=rs.getString(i+1);

				}
			}
			return data;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erreur : " + e.getMessage());
			return null;
		}

	}
	public String[][] select(String tableName,String key, Object value){
		String request="SELECT * FROM " + tableName + " WHERE "+ key + "='" + value +"'";
		return executeQuery(request);
	}
	public String[][] selectLike(String tableName,String key, String value){
		String request="SELECT * FROM " + tableName + " WHERE "+ key + " LIKE '%" + value +"%'";
		return executeQuery(request);
	}

	//had proc ltaht tab3a l produit dao (implementation)
	public boolean insert(String tablename, Object ...row) {

		//formuler le request 
		String req="insert into " + tablename + " values('"+ row[0] + "'";
		for (int i = 1; i < row.length; i++) {
			req=req + ", '" + row[i] +"'";
		}
		req=req+")";
		//insertion du request 
		try {
			Statement sql =db.createStatement();
			if(sql.executeUpdate(req)==1) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("erreur :  " +e.getMessage());
			return false;	
		}
	}
	public boolean delete(String tablename,String key, Object value) {
		String  req="DELETE FROM " + tablename + " WHERE " +key +" = '"+value + "'";
		try {
			Statement sql =db.createStatement();
			if(sql.executeUpdate(req)==1) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("erreur :  " +e.getMessage());
			return false;	
		}
	}
}
