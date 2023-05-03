package com.sruthiscompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sruthiscompany.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/")
	public String showLoginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public String welcomePage(ModelMap model,@RequestParam String name,@RequestParam String password) {
		boolean isValidUser=true;
		if(!isValidUser) {
			model.put("errorMessage", "Invalid user");
			return "login";
		}
		model.put("name", name);
		return "welcome";
	}

}
