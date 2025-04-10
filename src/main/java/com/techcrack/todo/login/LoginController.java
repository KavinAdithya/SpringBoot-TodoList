package com.techcrack.todo.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping
	public String redirectLoginPage(@RequestParam String name, ModelMap map) {
		map.put("name", name);
		return "login";
	}
}
