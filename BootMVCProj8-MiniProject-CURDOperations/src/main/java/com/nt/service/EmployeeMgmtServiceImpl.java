package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repository.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl  implements IEmployeeMgmtService {
	@Autowired
    private  IEmployeeRepo  empRepo;
	
	@Override
	public Iterable<Employee> getAllEmployees() {
		return empRepo.findAll(Sort.by("job").ascending());
	}

	@Override
	public String insertEmployee(Employee emp) {
	  		return "Employee inserted with id value:: "+ empRepo.save(emp).getEmpno();
	}

}
