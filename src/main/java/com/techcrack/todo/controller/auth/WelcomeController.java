package com.techcrack.todo.controller.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"name"})
public class WelcomeController {
	
	@RequestMapping(name = "/", method = RequestMethod.GET) 
	public String gotoWelcomePage(ModelMap model) {
		model.addAttribute("name", generateUserName());
		return "about/welcome";
	}
	
	private String generateUserName() {
		Authentication authentication = SecurityContextHolder.getContext()
																.getAuthentication();
		return authentication.getName();
	}	
}