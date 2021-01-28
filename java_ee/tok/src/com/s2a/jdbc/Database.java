package com.s2a.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;




public class Database 
{
	private DataSource ds;
	private Connection db;

	public Database()
	{
		
	}
	public Database(DataSource ds)
	{
		this.ds=ds;
		db=ds.getConnection();
	}
	
	public DataSource getDataSource() {
		return ds;
	}

	public void setDataSource(DataSource ds) {
		this.ds = ds;
		db = ds.getConnection();
		
	}

	void select()
	{
		String request= "SELECT * FROM authors WHERE Year_Born >0";
		try {
			Statement sql=db.createStatement();
			ResultSet rs=sql.executeQuery(request);
			while (rs.next()) 
			{
				//l indexation commence par 1 
				//getstring nous permet de passer par tout
				System.out.println(rs.getString(2));
			}
			
		} catch (SQLException e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}
	public String[][] executeQuery(String request)
	{
		try {
			Statement sql=db.createStatement();
			ResultSet rs=sql.executeQuery(request);
			ResultSetMetaData rsm= rs.getMetaData();
			//connaitre le nbr de ligne et le nbr de colonne
			int n= rsm.getColumnCount();
			rs.last();
			int m =rs.getRow(); //num de la ligne courante
			//creer une matrice de m+1 lignes et n colonnes
			String data[][]= new String[m+1][n];
			for (int i = 0; i < n; i++) {
				data[0][i]=rsm.getColumnName(i+1);//indexeer par 1 
			}
			rs.beforeFirst();
			int row=0;
			while (rs.next()) 
			{
				
				row++;
				for (int i = 0; i < n; i++) {
					data[row][i]=rs.getString(i+1); 
				}
				
			}
			return data;
			
		} catch (SQLException e) {
			System.out.println("Erreur : " + e.getMessage());
			return null;
		}
	}
	
	public String[][] select(String tableName)
	{
		String request= "SELECT * FROM "+tableName;
		return executeQuery(request);
				
			
	}
	public String[][] select(String tableName, String key, Object value)
	{
		String request = "SELECT * FROM " + tableName + " WHERE " + key + " = '" + value + "'";
		return executeQuery(request);
	}
	public String[][] selectLike(String tableName, String key, Object value)
	{
		String request = "SELECT * FROM " + tableName + " WHERE " + key + " LIKE '%" + value + " %'";
		return executeQuery(request);
	}
	public boolean insert(String tableName,Object ...row)
	{
		try {
			
			String request ="INSERT INTO "+tableName+ " VALUES ('" + row[0] + "'" ;
			for (int i = 1; i < row.length; i++)
			{
				request = request  + ",'" + row[i] + "'";
			}
			request=request+ ")";
			

			Statement sql=db.createStatement();
			int rs=sql.executeUpdate(request);
			if ( rs == 1)
				
			{return true;}
			else 
			{
				return false;
			}
		} catch (Exception e) {
			System.out.println("Erreur " + e.getMessage());
			return false;
		}
		
	}
	/*public boolean update (String tableName,Object ...row)
	{
		try {
			String request ="UPDATE "+tableName+ " SET( '" + row[0] ;
			for (int i = 1; i < row.length; i++)
			{
				request = request  + "," + row[i];
			}
			request=request+ " ')";
			

			Statement sql=db.createStatement();
			int rs=sql.executeUpdate(request);
			
			
		} catch (Exception e) {
			
		}
	}*/
	public boolean delete(String tableName, String key , Object value)
	{
		try
		{
			String request = "DELETE FROM " + tableName + " WHERE " + key + " = '" + value + "'";
			Statement sql=db.createStatement();
			int rs=sql.executeUpdate(request);
			if ( rs == 1)
				
			{return true;}
			else 
			{
				return false;
			}		
		}
		catch (Exception e) 
		{
			System.out.println("Erreur : " + e.getMessage());
			return false;
		}
	}

	
}
