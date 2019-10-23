package springboot.web;

import java.util.List;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import springboot.model.AddDocumentForm;
import springboot.model.Document;
import springboot.model.DocumentRevision;
import springboot.model.dao.DocumentDao;

@Controller
@RequestMapping(value = "/documents")
public class DocumentsController {

    @Autowired
    private DocumentDao documentDao;

    // Get list of documents in Documents Page
    @GetMapping
    public String documents(Model model) {
    	model.addAttribute("documents", documentDao.getDocuments());
        return "documents";
    }
    
    // Get the selected document
    @GetMapping("/{id}")
    public String document(@PathVariable int id, Model model) {
    	Document document = documentDao.getDocument(id);
    	model.addAttribute("document", document);
    	return "document";
    }
    
    // Delete document and its revisions
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        documentDao.deleteDocument(id);
    	return "redirect:/documents";
    }
    
    // Go to Add document screen
    @GetMapping("/add")
    public String add(Model model) {
    	model.addAttribute("form", new AddDocumentForm());
    	return "add_document";
    }
    
    // Post the Document
    @PostMapping("/post")
    public String post(@ModelAttribute AddDocumentForm form, @RequestParam("file") MultipartFile file) throws IOException {
    	Document document = new Document();
    	document.setName(form.getNameOfDocument());
    	String timestamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    	document.setLatestRevisionTimestamp(timestamp);
    	documentDao.addDocument(document);
    	
    	DocumentRevision revision = new DocumentRevision();
    	revision.setNote(form.getNote());
    	revision.setDateTimestamp(timestamp);
    	revision.setDocument(document);
    	revision.setFilename(file.getOriginalFilename());
    	revision.setFiletype(file.getContentType());
    	revision.setData(file.getBytes());
    	documentDao.addDocumentRevision(revision);
    	
    	return "redirect:/documents";
    }
    
    // Toggle Add Document Revision screen
    @GetMapping("/{id}/add")
    public String addDocumentRevision(@PathVariable int id, Model model) {
    	Document document = documentDao.getDocument(id);
    	model.addAttribute("document", document);
    	model.addAttribute("form", new AddDocumentForm());
    	return "add_document_revision";
    }
    
    // Post new Document Revision (with Uploaded File)
    @PostMapping("/{id}/post")
    public String postDocumentRevision(@ModelAttribute AddDocumentForm form, @PathVariable int id, @RequestParam("file") MultipartFile file) throws IOException {
    	String timestamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());    	
    	DocumentRevision revision = new DocumentRevision();
    	revision.setNote(form.getNote());
    	revision.setDateTimestamp(timestamp);
    	revision.setDocument(documentDao.getDocument(id));
    	revision.setData(file.getBytes());
    	revision.setFilename(file.getOriginalFilename());
    	revision.setFiletype(file.getContentType());
    	documentDao.addDocumentRevision(revision);
    	
    	return "redirect:/documents/" + id;
    }
    
    // Download file from Database...
    @RequestMapping(value="/{documentid}/download-revision/{revisionid}/{filename}", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity downloadFile(@PathVariable int documentid, @PathVariable int revisionid, Model model) {
        DocumentRevision revision = documentDao.getDocumentRevision(revisionid);
        return ResponseEntity.ok()
    			.contentType(MediaType.parseMediaType(revision.getFiletype()))
    			.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + revision.getFilename() + "\"")
    			.body(revision.getData());
    }
}