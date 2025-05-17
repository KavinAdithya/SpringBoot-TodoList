package com.techcrack.todo.controller.todo;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.techcrack.todo.data.UserEntityOperation;
import com.techcrack.todo.entity.Todo;
import com.techcrack.todo.service.todo.TodoManager;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/todos")
public class TodoOperation {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserEntityOperation service;
	
	@Autowired
	private TodoManager manage;
	
	@GetMapping("/home")
	public String getHomePage(@SessionAttribute(name = "name", required=false) String name) {
		if (name == null) {
			return "redirect:/todos/auth/login";
		}
		
		return "about/welcome";
	}
	
	@GetMapping("/todo-list")
	public String getTodos(@SessionAttribute(name = "id", required = false) Long id,  
							@SessionAttribute(name = "name", required = false) String name,
							ModelMap map) {
		
		if (name == null) {
			return "redirect:/todos/auth/login";
		}
		
		List<Todo> todos = service.getToByID(id);
		
		manage.setFormatterDate(todos);
		
		map.put("todos", todos);

		return "todos/todos";
	}
	
	@GetMapping("/add-todo")
	public String addViewReturn(ModelMap map, @SessionAttribute(name = "name", required=false) String name) {
		if (name == null) {
			return "redirect:/todos/auth/login";
		}
		
		Todo todo = new Todo();
		todo.setDescription("Hey Buddyy !!!!");
		
		map.put("todo", todo);
		
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
		
		service.addTodo(id, todo);
		log.debug(todo.toString());
		
		return "redirect:/todos/todo-list";
	}
	
	@GetMapping("delete-todo")
	public String deleteTodo(@RequestParam Long id, 
							@SessionAttribute(name="name", required=false) String name,
							@SessionAttribute(name="id", required=false) Long userId) {
		if (name == null) {
			return "redirect:/todos/auth/login";
		}
		
		service.deleteTodoById(userId, id);
		return "redirect:/todos/todo-list";
	}
	
	@GetMapping("update-todo") 
	public String updateTodo(
				@RequestParam Long id,
				ModelMap model, 
				@SessionAttribute(name = "name",required=false) String name,
				@SessionAttribute(name = "id", required=false) Long userId) {
		if (name == null) {
			return "redirect:/todos/auth/login";
		}
		
		List<Todo> todos = service.getUserById(userId).getTodos();
		
		Todo todo = manage.findTodo(todos, id);
		
		model.put("todo", todo);
		
		log.debug(todo.toString());
		
		return "todos/newTodoAdd";
	}
	
	
	@PostMapping("update-todo")
	public String updateTodo(@ModelAttribute("todo") @Valid Todo todo,
			BindingResult result, 
			@SessionAttribute(name = "name",required=false) String name,
			@SessionAttribute(name = "id", required=false) Long userId) {
		
		if (result.hasErrors()) {
			return "todos/newTodoAdd";
		}
		
		service.updateTodo(userId, todo, todo.getId());
		
		log.debug("Updated Todo Data");
		
		return "redirect:/todos/todo-list";
	}
}