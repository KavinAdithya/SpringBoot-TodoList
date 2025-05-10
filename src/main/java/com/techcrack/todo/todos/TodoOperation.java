package com.techcrack.todo.todos;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.techcrack.todo.data.UserEntityOperation;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/todos")
public class TodoOperation {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
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
	public String addViewReturn(ModelMap map, @SessionAttribute(name = "name", required=false) String name) {
		if (name == null) {
			return "redirect:/todos/auth/login";
		}
		
		Todo todo = new Todo();
		todo.setDescription("Kavin Adithya Likes Reading Books!!!");
		
		map.put("todo", todo);
		
//		System.out.println(todo);
//		log.debug(todo.toString());
		
		return "todos/newTodoAdd";
	}
	
	@PostMapping("/add-todo")
	public String renderTodo(@SessionAttribute(name = "id", required = false) Long id, 
							@SessionAttribute(name = "name", required = false) String name, 
							@ModelAttribute("todo") @Valid Todo todo,
							BindingResult result) {
		
		if (result.hasErrors()) {
			return "todos/newTodoAdd";
		}
		
		if (name == null) {
			return "redirect:/todos/auth/login";
		}
		
//		Todo todo = new Todo();
//		todo.setDescription(todo1description);
//		todo.setIsDone(false);
//		todo.setTargetDate(LocalDate.now());

		
		System.out.print("Logs....");
		service.addTodo(id, todo);
		log.debug(todo.toString());
		
		return "redirect:/todos/todo-list";
	}
}