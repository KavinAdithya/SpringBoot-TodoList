package com.techcrack.todo.todos;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.techcrack.todo.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="todos")
public class Todo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="todo_description")
	private String description;
	
	@Column(name="todo_target_date")
	private LocalDate targetDate;
	
	@Column(name="todo_work_done")
	private boolean isDone;
	
	public Todo() {
		super();
	}
	
	public Todo(Long id, User user, String description, LocalDate targetDate, boolean isDone) {
		super();
		this.id = id;
		this.user = user;
		this.description = description;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUsername() {
		return user;
	}

	public void setUsername(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(boolean isDone) {
		this.isDone = isDone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, isDone, targetDate, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		return Objects.equals(description, other.description) && id == other.id && isDone == other.isDone
				&& Objects.equals(targetDate, other.targetDate) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", description=" + description + ", targetDate="
				+ targetDate + ", isDone=" + isDone + "]";
	}
}