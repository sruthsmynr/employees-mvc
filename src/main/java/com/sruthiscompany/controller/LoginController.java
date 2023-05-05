package com.sruthiscompany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sruthiscompany.entity.Employee;
import com.sruthiscompany.model.EmployeeModel;
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
	public String welcomePage(ModelMap model,@RequestParam String email,@RequestParam String password) {
		Employee validUser=loginService.validUser(email, password);
		String role=loginService.getRole(email);
		if(validUser==null) {
			model.put("errorMessage", "Invalid user");
			return "login";
		}
		if(role.equals("ADMIN")) {
			List<Employee> employees=loginService.getAllEmployees();
			model.put("employees", employees);
		}else {
			model.put("employee", validUser);
		}
		model.put("role", role);
		return "welcome";
	}
	
	@GetMapping("/register")
	public String registerPage(Model model) {	
		model.addAttribute("emp",new EmployeeModel());
		return "register";
	}
	  
	@PostMapping("/saveData")
	public String saveData(@ModelAttribute("emp")EmployeeModel employeeModel,ModelMap model) {
		loginService.registerEmployee(employeeModel);
		model.put("successMessage", "Registration successful please login");
		return "login";
	}

}
