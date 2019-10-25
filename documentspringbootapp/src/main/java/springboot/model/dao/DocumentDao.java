package springboot.model.dao;

import java.util.List;

import springboot.model.Document;
import springboot.model.DocumentRevision;

public interface DocumentDao {

    Document getDocument(Integer id);
    
    DocumentRevision getDocumentRevision(Integer id);
    
    List<Document> getDocuments();
    
    void deleteDocument(Integer id);

	Document addDocument(Document document);

	DocumentRevision addDocumentRevision(DocumentRevision revision);
	
	DocumentRevision editDocumentRevision(DocumentRevision revision, String note);
}