package com.tutorials.sid.spring.services;

import org.springframework.stereotype.Service;

@Service
public class LoginServices {

	public boolean getValidation(String userName, String password) {
		return userName.equalsIgnoreCase("Siddhant") && password.equals("Sahu");
	}
}
