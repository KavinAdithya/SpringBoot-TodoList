package com.techcrack.todo.controller.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techcrack.todo.service.auth.AuthenticationService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/todos/auth")
@SessionAttributes({"name", "id"})
public class LoginController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AuthenticationService ser;
	
	@GetMapping("login")
	public String redirectLoginPage() {
		return "auth/login";
	}
	
	@PostMapping("login")
	public String authenticateLogin(@RequestParam String name, 
					@RequestParam String password, ModelMap map) {
		
		
		if (ser.isValidUserIdAndPassword(name, password)) {
			
			log.debug("User tried to login is {} and password is {}", name, password);
	
			map.put("name", name);
			map.put("password", password);
			map.put("id", 1);

			return "about/welcome";
		}
		
		map.put("error", "Invalid username or password");
		
		log.error("Failed to Login Due to Invalid Username: {} or Password : {}", name, password);
		return "auth/login";
	}
	
	@GetMapping("/logout")
	@ResponseBody
	public String logOut(HttpSession session) {
		session.invalidate();
		
		return "Successfully Logout the session";
	}
}