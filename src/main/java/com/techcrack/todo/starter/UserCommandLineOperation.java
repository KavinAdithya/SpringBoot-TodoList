package com.techcrack.todo.starter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.techcrack.todo.data.UserEntityOperation;
import com.techcrack.todo.entity.Todo;
import com.techcrack.todo.entity.User;

@Component
public class UserCommandLineOperation implements CommandLineRunner{
	
	@Autowired
	private UserEntityOperation ser;
	
	
	@Override
	public void run(String... args) {
		var user = new User();
		
		user.setPassword("dummy");
		user.setUsername("todo");
		
		var todo1 = new Todo();
		todo1.setDescription("First Todo");
		todo1.setIsDone(true);
		todo1.setTargetDate(LocalDate.now());
		todo1.setUsername(user);
		
		var todo2 = new Todo();
		todo2.setDescription("Second Todo");
		todo2.setIsDone(false);
		todo2.setTargetDate(LocalDate.now());
		todo2.setUsername(user);
		
		List<Todo> todos = new ArrayList<>();
		
		todos.add(todo1);
		todos.add(todo2);
		
		user.setTodos(todos);
		
		ser.saveUser(user);
	}
}
