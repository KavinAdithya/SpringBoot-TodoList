package com.techcrack.todo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@RequestMapping("/say-hello")
	@ResponseBody
	public String hello() {
		return "Hello Techies ! What are You Learning ? ";
	}
	
	@RequestMapping("/say-hello-html")
	@ResponseBody
	public String helloHtml() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("<head>");
		sb.append("<title>");
		sb.append("Html - Web");
		sb.append("</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("Kavin From Techcrack.");
		sb.append("</body>");
		
		return sb.toString();
	}
	
	@RequestMapping("/say-hello-jsp")
	public String helloHtmlJsp() {
		return "sayHello";
	}
}
