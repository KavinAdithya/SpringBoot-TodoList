package com.techcrack.todo.controller.todo;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techcrack.todo.data.UserEntityOperation;
import com.techcrack.todo.entity.Todo;
import com.techcrack.todo.service.todo.TodoManager;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoOperation {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserEntityOperation service;
	
	@Autowired
	private TodoManager manage;

	
	@RequestMapping(name="/list-todo", method = RequestMethod.GET)
	public String getTodos(ModelMap model) {	
		List<Todo> todos = service.getTodosByName(getUserName());
		
		manage.setFormatterDate(todos);
		
		model.put("todos", todos);

		return "todos/todos";
	}
	
	@RequestMapping(name=  "/add-todo", method = RequestMethod.GET)
	public String addViewReturn(ModelMap map) {
		
		Todo todo = new Todo();
		todo.setTargetDate(LocalDate.now());
		todo.setDescription("Hey Buddyy !!!!");
		
		map.put("todo", todo);
		
		return "todos/newTodoAdd";
	}
	
	@RequestMapping(name = "/add-todo", method = RequestMethod.POST)
	public String renderTodo( @ModelAttribute("todo") @Valid Todo todo,
							BindingResult result) {
		
		if (result.hasErrors()) {
			return "todos/newTodoAdd";
		}
		
		service.addTodo(getUserName(), todo);
		log.debug(todo.toString());
		
		return "redirect:/todo-list";
	}
	
	@RequestMapping(name = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam Long id) {
	
		service.deleteTodoById(getUserName(), id);

		return "redirect:/todo-list";
	}
	
	@RequestMapping(name = "/update-todo", method=RequestMethod.GET) 
	public String updateTodo(
				@RequestParam Long id,
				ModelMap model) {
		
		List<Todo> todos = service.getTodosByName(getUserName());
		
		Todo todo = manage.findTodo(todos, id);
		
		model.put("todo", todo);
		
		log.debug(todo.toString());
		
		return "todos/newTodoAdd";
	}
	
	
	@RequestMapping(name = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(@ModelAttribute("todo") @Valid Todo todo,
			BindingResult result) {
		
		if (result.hasErrors()) {
			return "todos/newTodoAdd";
		}
		
		service.updateTodo(getUserName(), todo, todo.getId());
		
		log.debug("Updated Todo Data");
		
		return "redirect:/todo-list";
	}
	
	private String getUserName() {
		Authentication authentication = SecurityContextHolder.getContext()
															.getAuthentication();
		
		return authentication.getName();
	}
	
//	service.getUserIdByUserName((String)model.getAttribute("name"))
}