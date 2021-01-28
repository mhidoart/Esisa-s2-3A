package com.s2a.actions;

import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.s2a.business.DocumentService;
import com.s2a.model.Document;



public class BiblioAction 
{
	private DocumentService business;
	private Hashtable<String,Document> docs;
	public BiblioAction() {
		docs = new Hashtable<>();
		docs.put("253-345-2334",new Document("253-345-2334","Technologie JAVA",2019));
		docs.put("123-245-6432",new Document("123-245-6432","Technologie .Net",2018));
		docs.put("876-765-1234",new Document("876-765-1234","Reseaux et Securite",2017));
	}
	
	public BiblioAction(DocumentService business) {
		super();
		this.business = business;
	}
	
	

	public void setBusiness(DocumentService business) {
		this.business = business;
	}

	public String documentList(HttpServletRequest request)
	{
		List<Document> vDocs = business.documents();
		request.setAttribute("model", vDocs);
		return "/views/DocList.jsp";
	}
	
	public String addDocument(HttpServletRequest request)
	{
		Document doc= new Document();
		doc.setIsbn(request.getParameter("isbn"));
		//doc.setTitle(request.getParameter("titre"));
		docs.put(doc.getIsbn(), doc);
		return "/views/DocList.jsp";
	}
}
