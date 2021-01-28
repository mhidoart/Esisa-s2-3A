package com.santa.server.gssss;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JTextArea;

public class Worker extends Thread {
	private Socket socket;
	private String request;
	private JTextArea txt;
	public Worker(Socket socket) {
		super();
		this.socket = socket;
	}
	
	public Worker(Socket socket, JTextArea txt) {
		super();
		this.socket = socket;
		this.txt = txt;
	}

	public Worker() {
	}
	@Override
	public void run() {
		readRequest();
		System.out.println(request);
		txt.append("Amis: " + request +"\n");
		
	}
	private void readRequest() {
		try {
			request="";
			InputStream is=socket.getInputStream();
			InputStreamReader  isr =new InputStreamReader(is);
			BufferedReader in = new BufferedReader(isr);
			String line=in.readLine();
			while(line != null && in.ready()) {
				request=request+line+"\n";
				line=in.readLine();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("erreur : "+ e.getMessage());
		}
	}

}
