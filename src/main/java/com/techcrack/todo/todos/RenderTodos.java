package com.techcrack.todo.todos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techcrack.todo.data.UserEntityOperation;

@Controller
@RequestMapping("/todos")
public class RenderTodos {
	
	@Autowired
	private UserEntityOperation ser;
	
	@GetMapping("/{id}")
	public String getTodos(@PathVariable Long id, ModelMap map) {
		List<Todo> todos = ser.getToByID(id);
		
		map.put("todos", todos);
		
		return "welcome";
	}
}
