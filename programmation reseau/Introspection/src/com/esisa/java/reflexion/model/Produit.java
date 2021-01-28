package com.esisa.java.reflexion.model;

import com.esisa.java.reflexion.annotations.Form;
import com.esisa.java.reflexion.annotations.Textfield;

@Form(title="Liste des Produits",labelWidth=200)
public class Produit {
	@Textfield(label="Reference ")
	private String ref;
	@Textfield(label="designation  ",size=30)
	private String desig;
	@Textfield(label="Prix unitaire  ",size=10)
	private double pu;
	@Textfield(label="Quantité en stock   ",size=10)
	private double qs;

	public Produit() {
		// TODO Auto-generated constructor stub
	}

}
