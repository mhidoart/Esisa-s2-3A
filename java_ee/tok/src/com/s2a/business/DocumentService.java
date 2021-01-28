package com.s2a.business;

import java.util.List;

import com.s2a.model.Document;

public interface DocumentService {


	public Document document(String isbn);
	public List<Document> documents();
	public List<Document> getDocumentbyKeyword(String keyword);
}
