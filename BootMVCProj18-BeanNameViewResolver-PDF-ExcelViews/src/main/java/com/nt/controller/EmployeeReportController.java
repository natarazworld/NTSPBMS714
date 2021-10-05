package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeReportController {
	@Autowired
	private IEmployeeMgmtService  service;
	
	@GetMapping("/")
	public  String showHome() {
		//return LVN
		return "home";
	}
	
	@GetMapping("/report")
	public String   generateReport(@RequestParam("type")String type,Map<String,Object> map) {
		//use service
		Iterable<Employee> empsList=service.getAllEmployees();
		//add to model attribute
		map.put("empsList",empsList);
		//return LVN
		if(type.equalsIgnoreCase("pdf"))
			return "pdfreport";
		else
			return "excelreport";
		
	}
	

}
