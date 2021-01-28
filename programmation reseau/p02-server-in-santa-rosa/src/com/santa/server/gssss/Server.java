package com.santa.server.gssss;

import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;

public class Server extends Thread {
	private int port=80;
	private JTextArea txt;
	public Server() {
		// TODO Auto-generated constructor stub
	}
	public Server(int port) {
		super();
		this.port = port;
	}
	
	public Server(int port, JTextArea txt) {
		super();
		this.port = port;
		this.txt = txt;
	}
	@Override
	public void run() {
		try {

			System.out.println("serveur encour de demarage !!!");
			ServerSocket socket = new ServerSocket(port);
			do {
				System.out.println("serveur demaree et encours d'ecout !!!");

				Socket s =socket.accept();
				Worker w=new Worker(s,txt);//ate3tiha khddam
				w.start();
			} while (true);



		} catch (Exception e) {
			System.out.println("erreur de serveur !! ");
		}
		System.out.println("server shutting down . :( ");

	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public static void main(String[] args) {
		Server s= new Server();
		s.start();
	}


}
