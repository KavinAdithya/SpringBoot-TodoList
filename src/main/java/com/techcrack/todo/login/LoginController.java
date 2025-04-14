package com.techcrack.todo.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AuthenticationService ser;
	
	@GetMapping
	public String redirectLoginPage() {
		return "login";
	}
	
	@PostMapping
	public String authenticateLogin(@RequestParam String name, 
					@RequestParam String password, ModelMap map) {
		
		
		if (ser.isValidUserIdAndPassword(name, password)) {
			log.debug("User tried to login is {} and password is {}", name, password);
			map.put("name", name);
			map.put("password", password);
			return "welcome";
		}
		
		map.put("error", "Invalid username or password");
		
		log.error("Failed to Login Due to Invalid Username: {} or Password : {}", name, password);
		return "login";
	}
}
