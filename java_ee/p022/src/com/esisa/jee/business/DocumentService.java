package com.esisa.jee.business;

import java.util.List;

import com.esisa.jee.models.Document;

public interface DocumentService {


	public Document document(String isbn);
	public List<Document> documents();
	public List<Document> getDocumentbyKeyword(String keyword);
}
