package com.esisa.jee.web.business;

import java.util.List;

import com.esisa.jee.dao.DocumentDao;
import com.esisa.jee.models.Document;

public class DocumentServiceefault implements DocumentService{
	private DocumentDao documentDao;
	
	public DocumentDao getDocumentDao() {
		return documentDao;
	}
	public void setDocumentDao(DocumentDao documentDao) {
		this.documentDao = documentDao;
	}
	public DocumentServiceefault(DocumentDao documentDao) {
		super();
		this.documentDao = documentDao;
	}
	public DocumentServiceefault() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Document documents(String isbn) {
		// TODO Auto-generated method stub
		return documentDao.select(isbn);
	}

	@Override
	public List<Document> documents() {
		// TODO Auto-generated method stub
		return documentDao.select();
	}

	@Override
	public List<Document> getDocumentByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return documentDao.selectByKeyword(keyword);
	}

}
