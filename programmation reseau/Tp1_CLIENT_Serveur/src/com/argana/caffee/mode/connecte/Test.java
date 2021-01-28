package com.argana.caffee.mode.connecte;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
		Client client = new Client();
	    client.startConnection("127.0.0.1", 80);
	    String response = client.sendMessage("hello server");
	    System.out.println(response);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test();
	}

}
