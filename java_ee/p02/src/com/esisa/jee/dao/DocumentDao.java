package com.esisa.jee.dao;

import java.util.List;

import com.esisa.jee.models.Document;

public interface DocumentDao {
		public boolean insert(Document doc);
		public void update(Document doc);
		public void delete(String isbn);
		public Document select(String isbn);
		public List<Document> select();
		public List<Document> selectByKeyword(String keyword);
}
