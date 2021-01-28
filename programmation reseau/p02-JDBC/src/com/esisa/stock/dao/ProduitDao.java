package com.esisa.stock.dao;

import java.util.List;

import com.esisa.stock.models.Produit;

public interface ProduitDao {
	public boolean insert(Produit p);
	public void update(Produit p);
	public boolean delete(String ref);
	public Produit select(String ref);
	public List<Produit> select();
}
