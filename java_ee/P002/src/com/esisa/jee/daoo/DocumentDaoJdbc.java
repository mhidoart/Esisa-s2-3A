package com.esisa.jee.daoo;

import java.util.List;
import java.util.Vector;

import com.esisa.jee.daoo.jdbc.Database;
import com.esisa.jee.daoo.mappers.BiblioMapper;
import com.esisa.jee.models.Document;

public class DocumentDaoJdbc implements DocumentDao {
	private Database db;
	private String tableName = "Titles";
	
	public DocumentDaoJdbc(Database db) {
		super();
		this.db = db;
	}
	
	public Database getDatabase() {
		return db;
	}

	public void setDatabase(Database db) {
		this.db = db;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
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
		String data[][] = db.select(tableName, "ISBN", isbn);
		if(data == null) return null;
		if(data.length <= 1) return null;
		Document doc = BiblioMapper.getDocument(data[1]);
		return doc;
	}

	@Override
	public List<Document> selectAll() {
		String data[][] = db.select(tableName);
		if (data == null) return null;
		Vector<Document> docs = new Vector<>();
		for (int i = 1; i < data.length; i++) {
			Document doc = BiblioMapper.getDocument(data[i]);
			docs.add(doc);
		}
		return docs;
	}

	@Override
	public List<Document> selectByKeyword(String keyword) {
		String data[][] = db.selectLike(tableName, "Title", keyword);
		if (data == null) return null;
		Vector<Document> docs = new Vector<>();
		for (int i = 1; i < data.length; i++) {
			Document doc = BiblioMapper.getDocument(data[i]);
			docs.add(doc);
		}
		return docs;
	}

}
