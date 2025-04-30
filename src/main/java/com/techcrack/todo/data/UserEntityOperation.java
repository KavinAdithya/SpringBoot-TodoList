package com.techcrack.todo.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techcrack.todo.todos.Todo;
import com.techcrack.todo.user.User;

@Repository
public class UserEntityOperation {
	
	@Autowired
	private UserRepository repo;
	
	public void saveUser(User user) {
		repo.save(user);
	}
	
	@SuppressWarnings("deprecation")
	public User getUserById(Long id) {
		return repo.getById(id);
	}
	
	public List<User> getAllUsers() {
		return repo.findAll();
	}
	
	@SuppressWarnings("deprecation")
	public List<Todo> getToByID(Long id) {
		return repo.getById(id).getTodos();
	}
	
	public void addTodo(Long id, Todo todo) {
		User user =  getUserById(id);
		user.getTodos().add(todo);
		todo.setUsername(user);
		saveUser(user);
	}
	
	public void deleteAll() {
		repo.deleteAll();
	}
	
	public void deleteById(Long id) {
		repo.deleteById(id);
	}
}
