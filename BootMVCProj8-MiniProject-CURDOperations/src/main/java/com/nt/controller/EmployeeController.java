package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeController {
	@Autowired
	 private IEmployeeMgmtService service;
	
	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/emp_report")
	public  String   showEmployeeReport(Map<String,Object> map) {
		//use service
		Iterable<Employee> empsList=service.getAllEmployees();
		//keep results as model attribute
		map.put("empsList", empsList);
		//return lvn;
		return "employee_report";
	}
	
	@GetMapping("/insert_employee")
	public  String   showAddEmployeeForm(@ModelAttribute("emp") Employee emp) {
		   //return LNV
		return "add_employee";
	}
	
	@PostMapping("/insert_employee")
	public  String insertEmployee(Map<String,Object> map,@ModelAttribute("emp")Employee emp) {
		//use service
		String result=service.insertEmployee(emp);
		Iterable<Employee> empList=service.getAllEmployees();
		//add result to model attribute 
		map.put("resultMsg",result);
		map.put("empsList",empList);
		//retunr LVN
		return "employee_report";
		
	}

}
