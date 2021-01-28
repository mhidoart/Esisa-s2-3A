package com.esisa.jee.web;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.esisa.jee.dao.DocumentDao;
import com.esisa.jee.dao.DocumentDaoJdbc;
import com.esisa.jee.jdbc.DataSource;
import com.esisa.jee.jdbc.Database;
import com.esisa.jee.jdbc.MYSQLDataSource;
import com.esisa.jee.models.Document;
import com.esisa.jee.web.actions.biblioAction;
import com.esisa.jee.web.business.DocumentService;
import com.esisa.jee.web.business.DocumentServiceefault;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


public class BiblioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private biblioAction action;
	private Vector<Document> docs;

	@Override
	public void init() throws ServletException {
		System.out.println(">>> init()");
		DataSource ds=new MYSQLDataSource("biblio");
		Database db = new Database(ds);
		DocumentDao documentDao =new DocumentDaoJdbc(db);
		DocumentService service= new DocumentServiceefault(documentDao);
		action=new biblioAction(service);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri =request.getRequestURI();
		System.out.println(uri);
		String view ="/views/Error.jsp";
		if(uri.endsWith("/DocumentList"))
		{
			view= action.documentList(request);
		}
		else if(uri.endsWith("/addDocument")){
			view= action.addDocument(request);

		}
		else if(uri.endsWith("/Authorlist")){
			
		}else if(uri.endsWith("/searchDocByKey")){
			view= action.searchDocByKey(request);
		}
		
			request.getRequestDispatcher(view).forward(request, response);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
