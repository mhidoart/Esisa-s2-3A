package com.esisa.reseau;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class couche_externe extends Thread {
	Socket appel;
	PrintWriter microphone; 
	BufferedReader hautParleur;
	public couche_externe(Socket appel) throws Exception
	{super(appel.getRemoteSocketAddress().toString());
		this.appel=appel;
		microphone =new PrintWriter(new BufferedWriter(new OutputStreamWriter(appel.getOutputStream())),true);
		hautParleur =new BufferedReader(new InputStreamReader(appel.getInputStream()));	
	}
	public void run() 
	{
		try{
		String message="";
		while (!message.equals(""))
		{
			message=hautParleur.readLine();
			System.out.println(this.getName()+"> "+message);
			microphone.println("OK" + message);
		}
		}
		catch(Exception e){System.out.println("Erreur :"+e.getMessage());}
	}
}
