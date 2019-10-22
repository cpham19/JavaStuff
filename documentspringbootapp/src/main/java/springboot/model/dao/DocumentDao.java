package springboot.model.dao;

import java.util.List;

import springboot.model.Document;

public interface DocumentDao {

    Document getDocument(Integer id);

    List<Document> getDocuments();
    
    void deleteDocument(Integer id);

	void addDocument(Document document);

}