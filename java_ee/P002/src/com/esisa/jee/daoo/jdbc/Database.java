package com.esisa.jee.daoo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.List;

//import com.esisa.stock.models.Produit;
import com.mysql.jdbc.Driver;

public class Database {
	private DataSource ds;
	private Connection db;
	
	public Database() {
		
	}
	
	public Database(DataSource ds) {
		this.ds = ds;
		db = ds.getConnection();
	}
	
	public void select() {
		String request = "SELECT * FROM Authors WHERE Year_Born > 0";
		try {
			Statement sql = db.createStatement();
			ResultSet rs = sql.executeQuery(request);
			while(rs.next()) {
				System.out.println(rs.getString(2));
				
			}
			
		} 
		catch (Exception e) {
			System.out.println("Erreur de Connexion : " + e.getMessage());
		}
	}
	
		public String[][] executeQuery(String request) {
			try {
				Statement sql = db.createStatement();
				ResultSet rs = sql.executeQuery(request);
				ResultSetMetaData rsm = rs.getMetaData();
				int n = rsm.getColumnCount();
				rs.last();
				int m = rs.getRow(); //num de la derniere ligne
				
				String data[][] = new String[m + 1][n];
				for (int i = 0; i < n; i++) {
					data[0][i] = rsm.getColumnName(i + 1); //indexee apartir de 1 et non pas 0
				}
				rs.beforeFirst();
				
				int row = 0;
				while(rs.next()) {
					row++;	
					for (int i = 0; i < n; i++) {
						data[row][i] = rs.getString(i + 1);
					}
				}
				return data;
			} 
			catch (Exception e) {
				System.out.println("Erreur de Connexion : " + e.getMessage());
				return null;
			}
		}
		
		public String[][] select(String tabbleName) {
			String request = "SELECT * FROM " + tabbleName;
			return executeQuery(request);
		}
		
		public String[][] select(String tableName, String key, Object value){
			String request = "SELECT * FROM " + tableName + " WHERE " + key + "='" + value + "'";
			return executeQuery(request);
		}
		
		public String[][] selectLike(String tableName, String key, Object value){
			String request = "SELECT * FROM " + tableName + " WHERE " + key + " LIKE '%" + value + "%'";
			return executeQuery(request);
		}
		
		public boolean insert(String tableName, Object...row) {
			
			String req = "INSERT INTO " + tableName +" VALUES('" + row[0] + "'";
			
			for (int i = 1; i < row.length; i++) {
				req = req + ", '" + row[i] + "'";
			}
			req = req + ")";
			try {
				Statement sql = db.createStatement();
				if (sql.executeUpdate(req) == 1) {
					return true;
				}
				else {
					return false;
				}
			} catch (Exception e) {
				System.out.println("Erreur : " + e.getMessage());
				return false;
			}
		}
		
		public boolean delete(String tableName, String key, Object value) {
			String req = "DELETE FROM " + tableName + " WHERE " + key + " = '" + value + "'";
			
			try {
				Statement sql = db.createStatement();
				if (sql.executeUpdate(req) == 1) {
					return true;
				}
				else {
					return false;
				}
			} catch (Exception e) {
				System.out.println("Erreur : " + e.getMessage());
				return false;
			}
		}
		
}	

