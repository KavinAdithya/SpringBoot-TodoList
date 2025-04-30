package com.techcrack.todo.todos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.techcrack.todo.data.UserEntityOperation;

@Controller
@RequestMapping("/todos")
public class TodoOperation {
	
	@Autowired
	private UserEntityOperation service;
	
	@GetMapping("/todo-list")
	public String getTodos(@SessionAttribute(name = "id", required = false) Long id,  
							@SessionAttribute(name = "name", required = false) String name,
							ModelMap map) {
		
		if (name == null) {
			return "redirect:/todos/auth/login";
		}
		
		List<Todo> todos = service.getToByID(id);
		
		map.put("todos", todos);

		return "todos/todos";
	}
	
	@GetMapping("/add-todo")
	public String addViewReturn(@SessionAttribute(name = "name", required=false) String name) {
		if (name == null) {
			return "redirect:/todos/auth/login";
		}
		
		return "todos/newTodoAdd";
	}
	
	@PostMapping("/add-todo")
	public String renderTodo(@SessionAttribute(name = "id", required = false) Long id, 
							@SessionAttribute(name = "name", required = false) String name, 
							@RequestParam String description) {
		
		if (name == null) {
			return "redirect:/todos/auth/login";
		}
		
		Todo todo = new Todo();
		todo.setDescription(description);
		todo.setIsDone(false);
		todo.setTargetDate(LocalDate.now());
		
		service.addTodo(id, todo);
		
		return "redirect:/todos/todo-list";
	}
}