package com.techcrack.todo.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/say-hello")
	@ResponseBody
	public String hello() {
		log.debug("Debug Log in Hello Controller");
		
		return "Hello Techies ! What are You Learning ? ";
	}
	
	@RequestMapping("/say-hello-html")
	@ResponseBody
	public String helloHtml() {
		StringBuffer sb = new StringBuffer();
		
		log.info("New {}", "Kabin");
		log.debug("Debug Log in Hello Controller say-hello-html");
		
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
