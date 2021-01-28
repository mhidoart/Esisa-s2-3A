package com.esisa.jee.business;

import java.util.List;

import com.esisa.jee.daoo.DocumentDao;
import com.esisa.jee.models.Document;

public class DocumentServiceDefault implements DocumentService{
	private DocumentDao documentDao;
	
	public DocumentServiceDefault() {
		
	}
	
	public DocumentServiceDefault(DocumentDao documentDao) {
		super();
		this.documentDao = documentDao;
	}
	
	public DocumentDao getDocumentDao() {
		return documentDao;
	}

	public void setDocumentDao(DocumentDao documentDao) {
		this.documentDao = documentDao;
	}

	@Override
	public Document documents(String isbn) {
		return documentDao.select(isbn);
	}

	@Override
	public List<Document> documents() {
		return documentDao.selectAll();
	}

	@Override
	public List<Document> getDocumentsByKeyword(String keyword) {
		return documentDao.selectByKeyword(keyword);
	}

	
}
