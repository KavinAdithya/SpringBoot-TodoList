package com.techcrack.todo.service.auth;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean isValidUserIdAndPassword(String name, String password) {
		return name.equalsIgnoreCase("techcrack@3") &&
				password.equalsIgnoreCase("dummy");
	}
}
