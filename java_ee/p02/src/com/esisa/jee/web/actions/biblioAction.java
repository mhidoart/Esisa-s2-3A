package com.esisa.jee.web.actions;

import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.swing.event.DocumentListener;

import com.esisa.jee.models.Document;
import com.esisa.jee.web.business.DocumentService;

public class biblioAction {
	private DocumentService business;
	private Hashtable<String, Document> docs;
	
	public String searchDocByKey(HttpServletRequest request) {
		String keyword=request.getParameter("keyword");
		List<Document> vdocs= business.getDocumentByKeyword(keyword); //new Vector<>(docs.values());
		request.setAttribute("docs", vdocs);
		request.setAttribute("message", "List de tous les docs" + keyword);
		return "/views/Document.jsp";
	}
	public biblioAction(DocumentService business) {
		super();
		this.business = business;
	}
	public void setBusiness(DocumentService business) {
		this.business = business;
	}
	public biblioAction() {
		docs=new Hashtable();
		docs.put("123-456-789",(new Document("123-456-789","dev en java ee ",2019)));
		docs.put("568-111-854",(new Document("568-111-854","arch java ee ",2019)));
		docs.put("182-556-246",(new Document("182-556-246","po ",2019)));
		}
	public String documentList(HttpServletRequest request) {
		List<Document> vdocs= business.documents(); //new Vector<>(docs.values());
		request.setAttribute("model", vdocs);
		return "/views/Document.jsp";
	}
	public String addDocument(HttpServletRequest request) {
		System.out.println(">>> adddocument()");
		Document doc = new Document();
		doc.setIsbn(request.getParameter("isbn"));
		//...
		docs.put(doc.getIsbn(), doc);
		Vector<Document> vdocs=new Vector<>(docs.values());
		request.setAttribute("model", vdocs);
		return "/views/Document.jsp";
	}
}
