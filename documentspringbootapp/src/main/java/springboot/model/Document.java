package springboot.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "documents")
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private int numberOfRevisions;

    private String latestRevisionTimestamp;
    
    // Get a set of Accounts for each Customer object
    @OneToMany(mappedBy="document")
    private List<DocumentRevision> docRevisions;
    
    public int getNumberOfRevisions() {
		return numberOfRevisions;
	}

	public void setNumberOfRevisions(int numberOfRevisions) {
		this.numberOfRevisions = numberOfRevisions;
	}

	public String getLatestRevisionTimestamp() {
		return latestRevisionTimestamp;
	}

	public void setLatestRevisionTimestamp(String latestRevisionTimestamp) {
		this.latestRevisionTimestamp = latestRevisionTimestamp;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public List<DocumentRevision> getDocRevisions() {
		return docRevisions;
	}

	public void setDocRevisions(List<DocumentRevision> docRevisions) {
		this.docRevisions = docRevisions;
	}
}

