package com.nt.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("java")
public final class JavaCourseMaterial implements ICourseMaterial {
	private Logger logger=LoggerFactory.getLogger(JavaCourseMaterial.class);
	
	public JavaCourseMaterial() {
		logger.trace("JAvaCourseMaterial :: 0-param constructor");
	}

	@Override
	public String courseContent() {
		logger.trace("JAvaCourseMaterial ::courseContent");
		return "1.oops ,2.Exception handling ,3. Collections and etc..";
	}

	@Override
	public double price() {
		logger.trace("JavaCourseMaterial.price()");
		return 400;
	}

}
