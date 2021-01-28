package com.esisa.jee.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.esisa.jee.business.DocumentService;
import com.esisa.jee.business.DocumentServiceDefault;
import com.esisa.jee.dao.DocumentDao;
import com.esisa.jee.dao.DocumentDaoJdbc;
import com.esisa.jee.dao.jdbc.DataSource;
import com.esisa.jee.dao.jdbc.Database;
import com.esisa.jee.dao.jdbc.MySQLDataSource;
import com.esisa.jee.web.actions.BiblioAction;

/**
 * Servlet implementation class BiblioServlet
 */
public class BiblioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BiblioAction action;

	//init est invoque par le constructeur , donc c est preferable de travailler avec init au lieu de constructeur 
	public void init() throws ServletException {
		System.out.println(">>>>>>>>>>>>>>>>>.init() : Wiring");
		DataSource ds= new MySQLDataSource("Biblio");
		Database db = new Database(ds);
		DocumentDao documentDao= new DocumentDaoJdbc(db);
		DocumentService  service= new DocumentServiceDefault(documentDao);
		
		action= new BiblioAction(service);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Url = > www.hjoiuyg.com/ghjoj
		//uri => /biblio/doc
		String uri=request.getRequestURI();
		System.out.println(uri);
		String  view = "/views/Erreur.jsp";


		if(uri.endsWith("/DocList")){

			view =action.documentList(request);
		}
		else if(uri.endsWith("/AuthList")){


		}
		else if(uri.endsWith("/AddDocument")){
			view= action.addDocument(request);

		}
		request.getRequestDispatcher(view).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
