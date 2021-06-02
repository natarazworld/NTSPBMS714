package com.nt.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("stud")
public final class Student {
	@Autowired
	//@Qualifier("java")
	private  ICourseMaterial  material;  // HAS-A property
	
	public  void  preparation(String examName) {
		System.out.println("preparation started for  "+examName);
		String courseConent =material.courseContent();
		double price =material.price();
		System.out.println("preparation is going on using"+courseConent+" material  with price ::"+price);
		System.out.println("preparation is completed for "+examName);
	}

}
