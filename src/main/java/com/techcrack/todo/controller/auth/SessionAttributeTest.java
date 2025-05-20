package com.techcrack.todo.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/dummy")
@SessionAttributes({"name", "id"})
public class SessionAttributeTest {
	
	@GetMapping("/set")
	@ResponseBody
	public String setData(ModelMap map) {
		map.addAttribute("name", "Spring MVC");
		map.addAttribute("id", 1);
		
		return "Data Seted";
	}
	
	@GetMapping("test")
	@ResponseBody
	public String findSession(ModelMap map) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(map.getAttribute("name"));
		sb.append(map.getAttribute("id"));
		
		map.put("name", "Spring Boot");
		map.put("id", 2);
		
		return sb.toString();
	}
}
