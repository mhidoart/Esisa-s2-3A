package com.esisa.model;

public class Joueur {
private int id;
private String nom;
private String prenom;
private String pays;
private String anneN ;
private int idEquipe;
private int num;
public Joueur(int id, String nom, String prenom, String pays, String anneN, int idEquipe, int num) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.pays = pays;
	this.anneN = anneN;
	this.idEquipe = idEquipe;
	this.num = num;
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
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getPays() {
	return pays;
}
public void setPays(String pays) {
	this.pays = pays;
}
public String getAnneN() {
	return anneN;
}
public void setAnneN(String anneN) {
	this.anneN = anneN;
}
public int getIdEquipe() {
	return idEquipe;
}
public void setIdEquipe(int idEquipe) {
	this.idEquipe = idEquipe;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}

}
