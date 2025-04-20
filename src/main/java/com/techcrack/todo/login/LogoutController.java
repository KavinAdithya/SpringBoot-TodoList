package com.techcrack.todo.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/todos/logout")
public class LogoutController {
	
	@GetMapping
	@ResponseBody
	public String logOut(HttpSession session) {
		session.invalidate();
		
		return "Successfully Logout the session";
	}
}
