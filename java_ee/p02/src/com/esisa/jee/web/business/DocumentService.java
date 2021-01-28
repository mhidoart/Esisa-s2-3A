package com.esisa.jee.web.business;

import java.util.List;

import com.esisa.jee.models.Document;

public interface DocumentService {
	public Document documents(String isbn);
	public List<Document> documents();
	public List<Document> getDocumentByKeyword(String keyword);
}
