package com.esisa.reseau;

import java.net.ServerSocket;
import java.net.Socket;

public class MultiClientTCP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
		ServerSocket service=new ServerSocket(12345);
		Socket appel;
		couche_externe pp;
		while(true)
		{
			appel=service.accept();
			System.out.println("un client vient de ce connecter:"+appel.getInetAddress());
			pp= new couche_externe(appel);
			pp.start();	
		}
		}
	catch(Exception e){System.out.println("Erreur :"+e.getMessage());}
	}

	

}
