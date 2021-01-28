package com.esisa.model;

public class Equipe {
private int id;
private String nom;
private String pays;

public Equipe(int id, String nom, String pays) {
	super();
	this.id = id;
	this.nom = nom;
	this.pays = pays;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPays() {
	return pays;
}
public void setPays(String pays) {
	this.pays = pays;
}

}
