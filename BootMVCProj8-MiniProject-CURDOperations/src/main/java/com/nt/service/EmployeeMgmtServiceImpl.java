package com.nt.service;

import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.exception.EmployeeNotFoundException;
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

	@Override
	public Employee getEmployeeByEno(int eno) {
		return empRepo.findById(eno).orElseThrow(()->new EmployeeNotFoundException("emp not found"));
				
	/*Optional<Employee> opt=empRepo.findById(eno);
		if(opt.isPresent())
			return opt.get();
		else
			throw  new EmployeeNotFoundException("emplolyee with ::"+eno+ " not found ");*/
	}
	
	@Override
	public String updateEmployee(Employee emp) {
		return  empRepo.save(emp).getEmpno()+" Employee updated";
	}
	
	@Override
	public String deleteEmployeeByEno(int eno) {
		empRepo.deleteById(eno);
		return eno+"  employee number  Employee deleted";
	}

}
