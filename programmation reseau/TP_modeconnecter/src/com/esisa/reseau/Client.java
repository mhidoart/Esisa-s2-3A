package com.esisa.reseau;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;


public class Client extends Thread{
	private String message;

	public Client(String message) {
		super();
		this.message = message;
	}
	public Client( ) {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) 
	{
		int i=0;
		while (i<10) {
			Client c=new Client("hasnae"+i);
			c.start();
			i++;
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try{
			Socket service;
			InetAddress ia=InetAddress.getByName("127.0.0.1");
			int port=80;
			//demande de connexion
			service=new Socket(ia,port);
			System.out.println("connexion etablie avec succes");
			PrintWriter microphone;
			BufferedReader hautParleur;
			microphone =new PrintWriter(new BufferedWriter(new OutputStreamWriter(service.getOutputStream())),true);
			hautParleur =new BufferedReader(new InputStreamReader(service.getInputStream()));
			System.out.println("message envoyer "+message);
			microphone.println(message);
			System.out.println(hautParleur.readLine());
		}
		catch(Exception e){System.out.println("Erreur sur :"+e.getMessage());}
	}
}

