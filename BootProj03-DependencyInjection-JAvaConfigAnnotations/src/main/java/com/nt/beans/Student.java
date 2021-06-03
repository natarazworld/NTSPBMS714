package com.nt.beans;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

@Named("stud")
public final class Student {
	//@Inject
	@Resource(name="courseId")
	//@Qualifier("${course.choose}")
	//@Named("courseId")
	private  ICourseMaterial  material;  // HAS-A property
	
	public  void  preparation(String examName) {
		System.out.println("preparation started for  "+examName);
		String courseConent =material.courseContent();
		double price =material.price();
		System.out.println("preparation is going on using"+courseConent+" material  with price ::"+price);
		System.out.println("preparation is completed for "+examName);
	}

}
