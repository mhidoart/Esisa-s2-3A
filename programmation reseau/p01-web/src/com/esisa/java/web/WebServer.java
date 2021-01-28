package com.esisa.java.web;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer extends Thread{
	private int port=80;
	public WebServer() {
		// TODO Auto-generated constructor stub
	}
	
	public WebServer(int port) {
		super();
		this.port = port;
	}

	@Override
	public void run() {
		try {
		ServerSocket ss=new ServerSocket(port);
		System.out.println("serveur demaré ....");
		do {
			System.out.println("serveur a l'ecoute ....");
			Socket socket=ss.accept();//instruction bloquante
			System.out.println("il y a une demande de connexion : ");
			ResponseTHread responseTHread = new ResponseTHread(socket);
			responseTHread.start();
		} while (true);
		}catch (Exception e) {
			System.out.println("erreur : "+ e.getMessage());
		}
	}
}
