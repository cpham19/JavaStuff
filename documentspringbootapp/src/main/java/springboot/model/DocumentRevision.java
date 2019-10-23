package springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "document_revisions")
public class DocumentRevision implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    private int revisionNum = 0;
    
    private String note;

    private String dateTimestamp;
    
    private String filename;
    
    private String filetype;
    
    @Lob
    @Column(length=100000)
    private byte[] data;
    
    @ManyToOne
    @JoinColumn(name="document_id")
    private Document document;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getRevisionNum() {
		return revisionNum;
	}

	public void setRevisionNum(int revisionNum) {
		this.revisionNum = revisionNum;
	}

	public String getDateTimestamp() {
		return dateTimestamp;
	}

	public void setDateTimestamp(String dateTimestamp) {
		this.dateTimestamp = dateTimestamp;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
}

