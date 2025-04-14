package com.techcrack.todo.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean isValidUserIdAndPassword(String name, String password) {
		return name.equalsIgnoreCase("techcrack") &&
				password.equalsIgnoreCase("dummy");
	}
}
