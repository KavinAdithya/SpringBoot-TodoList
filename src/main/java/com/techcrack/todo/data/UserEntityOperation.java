package com.techcrack.todo.data;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techcrack.todo.entity.Todo;
import com.techcrack.todo.entity.User;

@Repository
public class UserEntityOperation {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserRepository repo;
	
	public void saveUser(User user) {
		repo.save(user);
	}
	
	public User getUserByUsername(String username) {
		List<User> user = repo.findByUsername(username);
		return user != null ? user.getFirst() : null;
	}
	
	public List<User> getAllUsers() {
		return repo.findAll();
	}
	
	public List<Todo> getTodosByName(String username) {
		return getUserByUsername(username).getTodos();
	}
	
	public void addTodo(String username, Todo todo) {
		User user =  getUserByUsername(username);
		user.getTodos().add(todo);
		todo.setUsername(user);
		saveUser(user);
	}
	
	public void deleteAll() {
		repo.deleteAll();
	}
	
	public void deleteTodoById(String username, Long todoId) {
		User user = getUserByUsername(username);
		
		user.getTodos()
			.removeIf(x -> x.getId() == todoId);
		
		saveUser(user);
	}
	
	public void deleteById(Long id) {
		repo.deleteById(id);
	}
	
	public void updateTodo(String userId, Todo todo, Long id) {
		User user = getUserByUsername(userId);
		
		List<Todo> todos = user.getTodos();
		int index = findTodoIndex(todos, id);
		
		log.debug(todo + " is Found at " + index);
		
		Todo curTodo = todos.get(index);
		curTodo.setIsDone(todo.getIsDone());
		curTodo.setTargetDate(todo.getTargetDate());
		curTodo.setDescription(todo.getDescription());
		
		log.debug(user + "");
		
		saveUser(user);
	}
	
	private int findTodoIndex(List<Todo> todos, Long id) {
		int start = 0;
		int end = todos.size() - 1;
		
		while (start <= end) {
			int mid = start + (end - start) / 2;
			
			if (todos.get(mid).getId() == id) {
				return mid;
			}
			else if (todos.get(mid).getId() < id) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		
		return -1;
	}
}
