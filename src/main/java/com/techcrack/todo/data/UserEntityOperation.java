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
	
	public void deleteTodoById(Long userId, Long todoId) {
		User user = getUserById(userId);
		
		user.getTodos()
			.removeIf(x -> x.getId() == todoId);
		
		saveUser(user);
	}
	
	public void deleteById(Long id) {
		repo.deleteById(id);
	}
	
	public void updateTodo(Long userId, Todo todo, Long id) {
		User user = getUserById(userId);
		
		List<Todo> todos = user.getTodos();
		int index = findTodoIndex(todos, id);
		
		todos.remove(index);
		todos.add(index, todo);
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
