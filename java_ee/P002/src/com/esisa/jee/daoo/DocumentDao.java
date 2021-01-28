package com.esisa.jee.daoo;

import java.util.List;

import com.esisa.jee.models.Document;

public interface DocumentDao {
	public boolean insert(Document doc);
	public void update(Document doc);
	public void delete(String isbn);
	public Document select(String isbn);
	public List<Document> selectAll();
	public List<Document> selectByKeyword(String keyword);
}
