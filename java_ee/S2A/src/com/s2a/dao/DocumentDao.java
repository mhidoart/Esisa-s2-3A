package com.s2a.dao;

import java.util.List;

import com.s2a.model.Document;

public interface DocumentDao {
	
	public boolean insert(Document doc);
	public void update(Document  doc);
	public void delete(String isbn);
	public Document select(String isbn);
	public List<Document> selectAll();
	public List<Document> selectByKeyword(String keyword);


}
