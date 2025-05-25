package com.techcrack.todo.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techcrack.todo.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findByUsername(String username);
}
