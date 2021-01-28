/**
 * 
 */
package com.esisa.java.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author zrs
 *
 */
public class ResponseTHread extends Thread {
	private Socket socket;
	private String request;
	private String resource;
	public ResponseTHread() {
		// TODO Auto-generated constructor stub
	}
	public ResponseTHread(Socket socket) {
		super();
		this.socket = socket;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		readRequest();
		System.out.println(request);
		readRessource();
		System.out.println("ressource demander = "+ resource);
		sendResource();

		close();


	}
	private void readRequest() {
		try {
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
	private void readRessource(){
		int i= request.indexOf("/")+1;
		int j=request.indexOf(" ",i);
		if(i==j) {
			resource="index.html";
		}
		else
		{
			resource=request.substring(i,j);
		}
	}
	private void sendResource(){
		try {
			//raisonnee binaire
			OutputStream os=socket.getOutputStream();
			File in = new File("www/"+resource);
			if(in.exists()) {
				FileInputStream fis=new FileInputStream(in);
				byte bytes[]=new byte[(int)in.length()];
				fis.read(bytes);
				fis.close();
				os.write(bytes);
			}
			else
			{
				PrintWriter out =new PrintWriter(os);
				out.println("<h1>Ressource introuvable</h1>");
				out.close();
			}

			os.close();
			//resonnee text
			//PrintWriter out=new PrintWriter(os);
			//out.println("<h1>bienvenu sur votre premier serveur </h1>");
			//out.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("erreur : "+ e.getMessage());
		}
	}
	public void close() {
		try {
			socket.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("erreur : "+ e.getMessage());
		}
	}
	public String getRequest() {
		return request;
	}
	public String getResource() {
		return resource;
	}
}
