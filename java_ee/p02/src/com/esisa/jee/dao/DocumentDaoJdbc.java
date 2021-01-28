package com.esisa.jee.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.esisa.jee.dao.mappers.BiblioMapper;
import com.esisa.jee.jdbc.Database;
import com.esisa.jee.models.Document;

public class DocumentDaoJdbc implements DocumentDao{
	private Database db;
	private String tableName="Title";
	public DocumentDaoJdbc() {
		// TODO Auto-generated constructor stub
	}
	public Database getDb() {
		return db;
	}

	public void setDb(Database db) {
		this.db = db;
	}

	public DocumentDaoJdbc(Database db) {
		super();
		this.db = db;
	}

	@Override
	public boolean insert(Document doc) {
		return false;
	}

	@Override
	public void update(Document doc) {
		
	}

	@Override
	public void delete(String isbn) {
		
	}

	@Override
	public Document select(String isbn) {
		String data[][]=db.select(tableName, "ISBN", isbn);
		if(data==null) {
			return null;
		}
		if(data.length <=1) {
			return null;
		}
		Document doc = BiblioMapper.getDocument(data[1]);
		return doc;
	}

	@Override
	public List<Document> select() {
		String data[][]=db.select(tableName);
		if(data==null) {
			return null;
		}
		Vector<Document> docs=new Vector<>();
		for (int i = 1; i < data.length; i++) {
			docs.add(BiblioMapper.getDocument(data[i]));
		}
		return docs;
	}

	@Override
	public List<Document> selectByKeyword(String keyword) {
		String data[][]=db.select(tableName, "Title", keyword);
		if(data==null) {
			return null;
		}
		Vector<Document> docs=new Vector<>();
		for (int i = 1; i < data.length; i++) {
			docs.add(BiblioMapper.getDocument(data[i]));
		}
		return docs;
	}

}
