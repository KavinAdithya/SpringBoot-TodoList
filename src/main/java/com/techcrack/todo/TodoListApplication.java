package com.techcrack.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages={"com.techcrack.todo.entity"})
@EnableJpaRepositories(basePackages="com.techcrack.todo.data")
public class TodoListApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}

}
