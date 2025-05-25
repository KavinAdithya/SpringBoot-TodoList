package com.techcrack.todo.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfiguration {
	
//	@Bean
//	public InMemoryUserDetailsManager manageUserDetails() {
//		@SuppressWarnings("deprecation")
//		UserDetails user = User.withDefaultPasswordEncoder()
//								.username("techcrack")
//								.password("dummy")
//								.build();
//		
//		return new InMemoryUserDetailsManager(user);
//	}
	
	@Bean
	public InMemoryUserDetailsManager manageUserDetails() {
		// PassWord Encoder
//		Function<String, String> password = pass -> encodePassword().encode(pass);
		
		@SuppressWarnings("deprecation")
		UserDetails user = User.withDefaultPasswordEncoder()
								.username("techcrack")
								.password("dummy")
								.passwordEncoder(pass -> encodePassword().encode(pass))
								.roles("ADMIN", "USER")
								.build();
		
		return new InMemoryUserDetailsManager(user);
	}
	
	@Bean
	public BCryptPasswordEncoder encodePassword() {
		return new BCryptPasswordEncoder();
	}
}