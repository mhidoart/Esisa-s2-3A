package com.s2a.business;

import java.util.List;

import com.s2a.dao.DocumentDao;
import com.s2a.model.Document;


public class DocumentServiceDefault implements DocumentService {

	private DocumentDao documentDao;
	
	public DocumentServiceDefault() {
		super();
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
	public Document document(String isbn) {
		// TODO Auto-generated method stub
		return documentDao.select(isbn);
	}

	@Override
	public List<Document> documents() {
		// TODO Auto-generated method stub
		return documentDao.selectAll();
	}

	@Override
	public List<Document> getDocumentbyKeyword(String keyword) {
		// TODO Auto-generated method stub
		return documentDao.selectByKeyword(keyword);
	}

}
