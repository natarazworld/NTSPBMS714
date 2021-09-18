//EmployeeValidator.java
package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.model.Employee;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {  //This method is given to check
		System.out.println("EmployeeValidator.supports(-)");
		//return Employee.class==clazz;                //wheather handler method is  passing 
		return  clazz.isAssignableFrom(Employee.class);   // correct command class object or not
	}                                                                                           //if passed internally calls validate(-,-) otherwise throws exception

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("EmployeeValidator.validate(-)");
		//type casting
		Employee emp=(Employee)target;
		//server side form validation logic
		 
		if(emp.getEname()==null || emp.getEname().isBlank())  //required rule
			errors.rejectValue("ename","e.ename.required");
		else if (emp.getEname().length()<5)
			errors.rejectValue("ename","e.ename.minlength"); // minlength rule
		
		if(emp.getJob()==null || emp.getJob().isBlank())  //required rule
			errors.rejectValue("job","e.desg.required");
		else if (emp.getJob().length()<5)
			errors.rejectValue("job","e.desg.minlength" ); // minlength rule
		
		if(emp.getSal()==null )  //required rule
			errors.rejectValue("sal","e.sal.required" );
		else if (emp.getSal()<10000 || emp.getSal()>1000000)
			errors.rejectValue("sal","e.sal.range" ); // range rule
		
		if(emp.getDeptno()==null )  //required rule
			errors.rejectValue("deptno","e.deptno.required" );
		else if (emp.getDeptno()<10 || emp.getDeptno()>100)
			errors.rejectValue("deptno","e.deptno.range" ); // range rule

	}

}
