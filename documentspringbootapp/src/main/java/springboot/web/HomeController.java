package springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.model.Document;
import springboot.model.dao.DocumentDao;

@Controller
public class HomeController {
	@Value("${spring.application.name}")
	String appName;

	@RequestMapping("/")
	public String index(Model model) {
	     model.addAttribute("appName", appName);
	     return "home";
	}
}