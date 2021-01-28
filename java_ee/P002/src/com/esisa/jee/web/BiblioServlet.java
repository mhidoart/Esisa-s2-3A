package com.esisa.jee.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.esisa.jee.business.DocumentService;
import com.esisa.jee.business.DocumentServiceDefault;
import com.esisa.jee.daoo.DocumentDao;
import com.esisa.jee.daoo.DocumentDaoJdbc;
import com.esisa.jee.daoo.jdbc.DataSource;
import com.esisa.jee.daoo.jdbc.Database;
import com.esisa.jee.daoo.jdbc.MYSQLDataSource;
import com.esisa.jee.web.actions.BiblioAction;


/* <%@ tags de directives
 * <% tags de scripting : scriptlet
 * 						  tag d'expression
 * 						  tag de declaration
 * 	tags d'action
 * 	expression langages(EL) ${model }
 * */
public class BiblioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	private BiblioAction action;
	
	@Override
	public void init() throws ServletException {
		System.out.println(">>>init() : Wiring");
		DataSource ds = new MYSQLDataSource("Biblio");
		Database db = new Database(ds);
		DocumentDao documentDao = new DocumentDaoJdbc(db);
		DocumentService service = new DocumentServiceDefault(documentDao);
		action = new BiblioAction();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); //Biblio/DocumentList 
		System.out.println(uri);
		String view = "/views/Error.jsp";
		
		if(uri.endsWith("/DocumentList")) {
			view = action.documentList(request);	
		}
		else if (uri.endsWith("/AddDocument")) {
			view = action.AddDocument(request);
		}
		else if (uri.endsWith("/AuthorList")) {
			
		}
		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
