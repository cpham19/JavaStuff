package springboot.web;

import java.util.List;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import springboot.model.AddDocumentForm;
import springboot.model.Document;
import springboot.model.DocumentRevision;
import springboot.model.dao.DocumentDao;

//@Controller
@RestController
@RequestMapping("/documents")
public class DocumentsController {

	@Autowired
	private DocumentDao documentDao;

	// Delete document and its revisions
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		try {
			documentDao.deleteDocument(id);
		}
		catch (Exception e) {

		}
		return "DELETED DOCUMENT #" + id;
	}  

	// Get list of documents in Documents Page
	@GetMapping
	public List<Document> documents(ModelMap models) {
		return documentDao.getDocuments();
	}

	// Get the selected document
	@GetMapping("/{id}")
	public List<DocumentRevision> document(@PathVariable int id, Model model) throws MalformedURLException {
		Document document = documentDao.getDocument(id);
		List<DocumentRevision> revisions = document.getDocRevisions();
		return revisions;
	}

	// Post new Document (with Uploaded File)
	@PostMapping("/post")
	public Document postDocument(@RequestParam String name, @RequestParam String note, @RequestParam("file") MultipartFile file) throws IOException {
    	Document document = new Document();
    	document.setName(name);
    	String timestamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    	document.setLatestRevisionTimestamp(timestamp);
    	document = documentDao.addDocument(document);
    	
    	DocumentRevision revision = new DocumentRevision();
    	revision.setNote(note);
    	revision.setDateTimestamp(timestamp);
    	revision.setDocument(document);
    	revision.setFilename(file.getOriginalFilename());
    	revision.setFiletype(file.getContentType());
    	revision.setData(file.getBytes());
    	
    	revision = documentDao.addDocumentRevision(revision);

		return document;
	}

	// Post new Document Revision (with Uploaded File)
	@PostMapping("/{id}/post")
	public DocumentRevision postDocumentRevision(@RequestParam String note, @PathVariable int id, @RequestParam("file") MultipartFile file) throws IOException {
		String timestamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());    	
		DocumentRevision revision = new DocumentRevision();
		revision.setNote(note);
		revision.setDateTimestamp(timestamp);
		revision.setDocument(documentDao.getDocument(id));
		revision.setData(file.getBytes());
		revision.setFilename(file.getOriginalFilename());
		revision.setFiletype(file.getContentType());
		
		revision = documentDao.addDocumentRevision(revision);

		return revision;
	}

	// Submit Editted Document Revision (with Uploaded File)
	@PutMapping(value = "/{documentid}/edit-revision/{revisionid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DocumentRevision submitEdit(@RequestParam String note, @PathVariable int documentid, @PathVariable int revisionid) throws MalformedURLException {
		DocumentRevision documentRevision = null;
		try {
			documentRevision = documentDao.getDocumentRevision(revisionid);
		}
		catch(Exception e) {

		}
		
		return documentDao.editDocumentRevision(documentRevision, note);
	}


	// Download file from Database...
	@RequestMapping(value="/{documentid}/download/{revisionid}/{filename}", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity downloadFile(@PathVariable int documentid, @PathVariable int revisionid, Model model) {
		DocumentRevision revision = documentDao.getDocumentRevision(revisionid);
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(revision.getFiletype()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + revision.getFilename() + "\"")
				.body(revision.getData());
	}
}