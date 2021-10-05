package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repository.IEmployeeRepo;

@Service("emp")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepo  empRepo;

	@Override
	public Iterable<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

}
