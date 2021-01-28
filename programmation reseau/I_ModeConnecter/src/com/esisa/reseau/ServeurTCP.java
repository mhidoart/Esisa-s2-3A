package com.esisa.reseau;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurTCP  {
	private String nom;
	public ServeurTCP(String nom) {
		// TODO Auto-generated constructor stub
		this.nom=nom;
		server();
	}
	public void  server() {
		
		 try (ServerSocket serverSocket = new ServerSocket (80)){
	            System.out.println("Server is listing client");

	            while (true) {
	                System.out.println("ready to Connect with new client");
	                Socket socket = serverSocket.accept();
	                System.out.println("connected");
	                OutputStream output = socket.getOutputStream();
	                PrintWriter sendMessage = new PrintWriter (output);
	                sendMessage.println("<h1>Hello from server</h1>");
	            }
	        } catch (IOException ex) {
	            System.out.println("Server message " + ex.getMessage());
	            ex.printStackTrace();
	        }
		
	}
	public static void main(String[] args) {
		new ServeurTCP("my server");
	}

}
