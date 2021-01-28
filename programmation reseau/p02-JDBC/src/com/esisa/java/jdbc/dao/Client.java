package com.esisa.java.jdbc.dao;

public class Client {

	public Client() {
		// TODO Auto-generated constructor stub
		exp04();
	}
	void exp01() {
		DataSource ds=new MYSQLDataSource("biblio");
		Database db=new Database(ds);
	}
	void exp02() {
		DataSource ds=new MYSQLDataSource("biblio");
		Database db=new Database(ds);
		String data[][]=db.select("authors");
		print(data);
		
	}
	void exp03() {
		DataSource ds=new MYSQLDataSource("biblio");
		Database db=new Database(ds);
		String data[][]=db.selectLike("Titles","Title","java");
		print(data);
		
	}
	void exp04() {
		DataSource ds=new MYSQLDataSource("biblio");
		Database db=new Database(ds);
		String data[][]=db.select("Authors","Au_ID",240);
		print(data);
		
	}
	void print(String data[][] ) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.print( data[i][j] + ",");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		new Client();
	}

}
