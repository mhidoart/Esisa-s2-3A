package com.esisa.reseau;

public class Test {
	public Test() {
		// TODO Auto-generated constructor stub
		exp01();
	}
	void exp01() {
		//ServeurTCP server=new ServeurTCP("argana");
		
		ClientTCP client=new ClientTCP();
		client.start();
		do {
			double n=5*5*55*5*5*5*5*5*5*5*55*5*5*5*5;
		} while (true);
		
		
	}
public static void main(String[] args) {
	new Test();
}
}
