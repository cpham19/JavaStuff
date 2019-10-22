package springboot.web;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import springboot.model.Document;
import springboot.model.dao.DocumentDao;

@Controller
@RequestMapping(value = "/documents")
public class DocumentsController {

    @Autowired
    private DocumentDao documentDao;

    @GetMapping
    public String documents(Model model) {
    	model.addAttribute("documents", documentDao.getDocuments());
        return "documents";
    }
    
    @GetMapping("/{id}")
    public String document(@PathVariable int id, Model model) {
    	Document document = documentDao.getDocument(id);
    	model.addAttribute("document", document);
    	return "document";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        documentDao.deleteDocument(id);
    	return "redirect:/documents";
    }
    
    @GetMapping("/add")
    public String add(Model model) {
    	model.addAttribute("document", new Document());
    	return "add_document";
    }
    
    @PostMapping("/post")
    public String post(@ModelAttribute Document document) {
    	document.setNumberOfRevisions(1);
    	String timestamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    	document.setLatestRevisionTimestamp(timestamp);
    	documentDao.addDocument(document);
    	return "redirect:/documents";
    }
}