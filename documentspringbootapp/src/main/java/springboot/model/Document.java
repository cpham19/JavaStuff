package springboot.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
}