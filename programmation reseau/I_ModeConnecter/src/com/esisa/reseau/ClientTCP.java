package com.esisa.reseau;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import javax.print.DocFlavor.STRING;

public class ClientTCP extends Thread {
	private String nom;
	public ClientTCP() {
		// TODO Auto-generated constructor stub
	}

	public ClientTCP(String nom) {
		super();
		this.nom = nom;
	}
	public static void pause(long time) {
		try {
			Thread.sleep(time);
		}
		catch(Exception e) {
			System.out.println("erreur pause");
		}
	}

	public static void main (String [] args) {
		try (Socket socket = new Socket ("127.0.0.1", 80)){
			InputStream input = socket.getInputStream();
			BufferedReader reader = new BufferedReader (new InputStreamReader (input)); 
			System.out.println(reader.readLine());

		} catch (Exception ex) {
			System.out.println("Client message " + ex.getMessage());
			//ex.printStackTrace();
		}
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


}
