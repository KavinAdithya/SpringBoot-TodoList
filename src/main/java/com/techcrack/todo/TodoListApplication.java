package com.techcrack.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages={"com.techcrack.todo.entity"})
@EnableJpaRepositories(basePackages="com.techcrack.todo.data")
public class TodoListApplication {
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//	    String password = UUID.randomUUID().toString();
//	    System.out.println("Generated password: " + password); // 👈 Easy to find
//	    UserDetails user = User.withUsername("user")
//	        .password("{noop}" + password)
//	        .roles("USER")
//	        .build();
//	    return new InMemoryUserDetailsManager(user);
//	}


	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}

}
