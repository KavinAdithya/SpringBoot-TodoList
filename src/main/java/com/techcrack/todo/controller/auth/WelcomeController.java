package com.techcrack.todo.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"name", "id"})
public class WelcomeController {
	
	@RequestMapping(name = "/", method = RequestMethod.GET) 
	public String gotoWelcomePage(ModelMap model) {
		model.addAttribute("name", "Techcrack");
		model.addAttribute("id", 1);
		return "about/welcome";
	}
	
}