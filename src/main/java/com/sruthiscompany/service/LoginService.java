package com.sruthiscompany.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sruthiscompany.entity.Employee;
import com.sruthiscompany.entity.Login;
import com.sruthiscompany.model.EmployeeModel;
import com.sruthiscompany.repository.EmployeeRepository;
import com.sruthiscompany.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private LoginRepository loginRepo;
	
	public Employee validUser(String email,String password) {
		Employee employee=null;
		List<Employee> employees=empRepo.findAll();
		for(Employee emp:employees) {
			if(emp.getEmail().equals(email) && emp.getPassword().equals(emp.getPassword())) {
				employee= emp;
				break;
			}
		}
		return employee;
	}
	
	public String getRole(String email) {
		Login loginInfo=loginRepo.findByEmail(email);
		if(loginInfo==null)
			return "";
		return loginInfo.getRole();
	}
	
	public List<Employee> getAllEmployees(){
		List<Employee> employees=empRepo.findAll();
        return employees;
	}
	
	public void registerEmployee(EmployeeModel empmodel) {
		Employee emp=new Employee();
		emp.setFirstName(empmodel.getFirstname());
		emp.setMiddleName(empmodel.getMiddlename());
		emp.setLastName(empmodel.getLastname());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		try {
			emp.setDob(sdf.parse(empmodel.getDob()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		emp.setEmail(empmodel.getEmail());
		emp.setPassword(empmodel.getPassword());
		emp.setPhone(empmodel.getPhone());
		emp.setDesignation(empmodel.getDesignation());
		empRepo.save(emp);
		try {
		Login loginInfo=new Login();
		loginInfo.setEmail(empmodel.getEmail());
		loginInfo.setPassword(empmodel.getPassword());
		loginInfo.setRole("EMP");
		Date date=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-mm-dd");
		String format=formatter.format(date);
		date=formatter.parse(format);
		loginInfo.setCreatedDate(date);
		loginRepo.save(loginInfo);
		}catch(ParseException ex) {
		}
		
	}

}
