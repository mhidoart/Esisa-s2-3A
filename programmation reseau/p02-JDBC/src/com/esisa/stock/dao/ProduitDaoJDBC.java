package com.esisa.stock.dao;

import java.util.List;
import java.util.Vector;

import com.esisa.java.jdbc.dao.Database;
import com.esisa.stock.models.Produit;

public class ProduitDaoJDBC implements ProduitDao {
	private Database db;
	public ProduitDaoJDBC() {
		// TODO Auto-generated constructor stub
	}
	
	public ProduitDaoJDBC(Database db) {
		super();
		this.db = db;
	}
	
	public void setDatabase(Database db) {
		this.db = db;
	}
	public Database getDb() {
		return db;
	}

	@Override
	public boolean insert(Produit p) {
		// TODO Auto-generated method stub
		return  db.insert("Produit", p.getRef(),p.getDesig(),p.getPu(),p.getQs());
	}

	@Override
	public void update(Produit p) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Produit select(String ref) {
	
		String data[][]= db.select("produit" ,"ref", ref);
			if(data != null && data.length >= 2) {
				return new Produit(data[1]);
			}
		return null;
	}

	@Override
	public List<Produit> select() {
		List<Produit> list=new Vector<>();
		String data[][]= db.select("produit");
		for (int i = 1; i < data.length; i++) {
			list.add(new Produit(data[i]));
		}	
		return list;
	}

	@Override
	public boolean delete(String ref) {
		// TODO Auto-generated method stub
		return db.delete("produit", "ref", ref);
	}
	
	


}
