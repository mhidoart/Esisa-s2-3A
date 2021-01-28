package com.esisa.stock.swing;

import java.util.List;

import com.esisa.java.jdbc.dao.DataSource;
import com.esisa.java.jdbc.dao.Database;
import com.esisa.java.jdbc.dao.MYSQLDataSource;
import com.esisa.stock.dao.ProduitDao;
import com.esisa.stock.dao.ProduitDaoJDBC;
import com.esisa.stock.models.Produit;

public class Examples {

	public Examples() {
		// TODO Auto-generated constructor stub
		exp04();
	}
	void exp01() {
		DataSource ds=new MYSQLDataSource("Stock", "root", "root");
		Database db=new Database(ds);
		ProduitDao pdao=new ProduitDaoJDBC(db);
		Produit t[]= {
				new Produit("0","ecran",12.5,10.2),
				new Produit("1","cle usb",2400,7),
				new Produit("2","clavier",176,12),				
		};
		for (Produit p : t) {
			pdao.insert(p);
		}				
	}
	void exp02() {
		DataSource ds=new MYSQLDataSource("Stock", "root", "root");
		Database db=new Database(ds);
		ProduitDao pdao=new ProduitDaoJDBC(db);
		List<Produit> plist=pdao.select();
	
		for (Produit k : plist) {
			System.out.println(k);
		}
	}
	void exp03() {
		DataSource ds=new MYSQLDataSource("Stock", "root", "root");
		Database db=new Database(ds);
		ProduitDao pdao=new ProduitDaoJDBC(db);
		Produit k=pdao.select("123");
	
		if(k!=null) {
			System.out.println(k);
		}
	}
	void exp04() {
		DataSource ds=new MYSQLDataSource("Stock", "root", "root");
		Database db=new Database(ds);
		ProduitDao pdao=new ProduitDaoJDBC(db);
		
	
		if(pdao.delete("123")==true) {
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}
	}
	public static void main(String[] args) {
		new Examples();
	}
}
