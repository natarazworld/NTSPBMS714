package com.nt.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

  
@Component("stud")
public final class Student {
	private Logger logger=LoggerFactory.getLogger(Student.class);
	@Autowired
	//@Qualifier("${course.choose}")
	@Qualifier("courseId")
	private  ICourseMaterial  material;  // HAS-A property
	
	public  void  preparation(String examName) {
		logger.trace("start of method prepration(-)");
		System.out.println("preparation started for  "+examName);
		String courseConent =material.courseContent();
		logger.info("course content is gathered");
		double price =material.price();
		logger.info("course meterial  price is gathered");
		logger.debug("Dependent obj services are used");
		System.out.println("preparation is going on using"+courseConent+" material  with price ::"+price);
		System.out.println("preparation is completed for "+examName);
		logger.trace("end of method ;; preparation(-)");
	}

}
