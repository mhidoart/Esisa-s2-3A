package com.esisa.jee.web.actions;

import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.esisa.jee.business.DocumentService;
import com.esisa.jee.models.Document;
/////////////////////////////////////////////////////Classe d'actions
public class BiblioAction {
	private DocumentService business;
	
	private Hashtable<String,Document> docs;
	
	public BiblioAction() {
		docs = new Hashtable<>();
		docs.put("345-767-4511",new Document("345-767-4511","Développement web en Java",2019));
		docs.put("345-767-4534",new Document("345-767-4534","Modele MVC2",2018));
		docs.put("345-767-4566",new Document("345-767-4566","Architecture JavaEE",2017));
	}
	
	public BiblioAction(DocumentService business) {
		super();
		this.business = business;
	}
	
	public void setBusiness(DocumentService business) {
		this.business = business;
	}

	//////////////////////////////////////////////////Methodes
	public String documentList(HttpServletRequest request) {
		List<Document> vDocs = business.documents();
		request.setAttribute("model", vDocs);
		return "/views/DocumentList.jsp";
	}
	
	public String AddDocument(HttpServletRequest request) {
		System.out.println(">>>AddDocument()");
		Document doc = new Document();
		doc.setIsbn(request.getParameter("isbn"));
		doc.setTitle(request.getParameter("title"));
		
		docs.put(doc.getIsbn(), doc);
		
		Vector<Document> vDocs = new Vector<>(docs.values());
		request.setAttribute("model", vDocs);
		return "/views/DocumentList.jsp";
	}
}
