package com.esisa.reseau;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
	public static void main(String[] args) {
		try
		{
		while (true) {
			System.out.println("Serveur en attent");
			ServerSocket service=new ServerSocket(80);
			Socket call=service.accept();
			System.out.println("Connexion bien établie");
			PrintWriter microphone =new PrintWriter(new BufferedWriter(new OutputStreamWriter(call.getOutputStream())),true);
			BufferedReader hautParleur =new BufferedReader(new InputStreamReader(call.getInputStream()));
			String message=hautParleur.readLine();
			System.out.println("Message recu du client est :"+message);
			microphone.println(message+"ok");
		}
		}
		catch(Exception e){System.out.println("erreur :"+e.getMessage());}
	}

}
