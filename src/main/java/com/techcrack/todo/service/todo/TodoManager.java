package com.techcrack.todo.service.todo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.techcrack.todo.entity.Todo;

@Service
public class TodoManager {
	private String getFormatDate(LocalDate localDate) {
		String date = localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		
		return date;
	}
	
	public void setFormatterDate(List<Todo> todos) {
		for (Todo todo : todos) {
			todo.setFormatedDate(getFormatDate(todo.getTargetDate()));
		}
	}
	
	public Todo findTodo(List<Todo> todos, Long id) {
		return todos.stream()
					.filter(x -> x.getId() == id)
					.toList()
					.get(0);
	}
}
