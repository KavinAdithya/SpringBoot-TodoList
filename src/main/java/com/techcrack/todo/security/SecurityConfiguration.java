package com.techcrack.todo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfiguration {
	
	@Bean
	public InMemoryUserDetailsManager manageUserDetails() {
		@SuppressWarnings("deprecation")
		UserDetails user = User.withDefaultPasswordEncoder()
		.username("techcrack")
		.password("dummy")
		.build();
		
		return new InMemoryUserDetailsManager(user);
	}
}
