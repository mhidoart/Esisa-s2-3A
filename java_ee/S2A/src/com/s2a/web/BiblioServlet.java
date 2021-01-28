package com.s2a.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.s2a.actions.BiblioAction;
import com.s2a.business.DocumentService;
import com.s2a.business.DocumentServiceDefault;
import com.s2a.dao.DocumentDao;
import com.s2a.dao.DocumentDaoJdbc;
import com.s2a.jdbc.DataSource;
import com.s2a.jdbc.Database;
import com.s2a.jdbc.MySQLDataSource;


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
