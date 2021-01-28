package com.esisa.jee.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.esisa.jee.dao.DataSource;
import com.esisa.jee.dao.Database;
import com.esisa.jee.dao.MYSQLDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


@WebServlet({ "/FirstServlet", "/p01.html","/ListeDesAuteurs" })
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private Database db;
    public FirstServlet() {
       DataSource ds =new MYSQLDataSource("biblio","root","root");
       db=new Database(ds);
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		if(uri.endsWith("/p01.html")) {
			PrintWriter out=  response.getWriter();
			out.println("<h1>reponse de ma first servlet </h1>");
		}
		else if(uri.endsWith("/ListeDesAuteurs")) {
			PrintWriter out=  response.getWriter();
			String data[][]=db.select("Authors");
			out.println("<table border='1' style='border-collapse: collapse; width: 100%;'");
			for (int i = 0; i < data.length; i++) {
				out.println("<tr>");
				for (int j = 0; j < data[i].length; j++) {
					out.println("<td>"+data[i][j]+"</td>");
				}
				out.println("</tr>");
				
			}
			out.println("</table>");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
