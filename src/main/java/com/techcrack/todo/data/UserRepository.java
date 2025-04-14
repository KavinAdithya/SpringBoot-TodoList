package com.techcrack.todo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techcrack.todo.user.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
