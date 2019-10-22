package springboot.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springboot.model.Document;
import springboot.model.dao.DocumentDao;;

@Repository
public class DocumentDaoImpl implements DocumentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Document getDocument(Integer id) {
        return entityManager.find(Document.class, id);
    }

    @Override
    public List<Document> getDocuments() {
        return entityManager.createQuery("from Document", Document.class)
                .getResultList();
    }

	@Override
	@Transactional
	public void deleteDocument(Integer id) {
		Document document = this.getDocument(id);
		entityManager.remove(document);
	}
    
	@Override
	@Transactional
	public void addDocument(Document document) {
		entityManager.persist(document);
	}
}