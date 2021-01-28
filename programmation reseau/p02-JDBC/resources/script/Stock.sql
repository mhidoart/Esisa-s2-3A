create database Stock;
USE Stock;
CREATE table Produit(
	ref VARCHAR(10),
	desig varchar(30),
	pu double,
	qs double,
	PRIMARY KEY(ref)
);