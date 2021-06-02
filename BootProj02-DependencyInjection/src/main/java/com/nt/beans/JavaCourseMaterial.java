package com.nt.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("java")
public final class JavaCourseMaterial implements ICourseMaterial {
	
	public JavaCourseMaterial() {
		System.out.println("JavaCourseMaterial:: 0-param constructor");
	}

	@Override
	public String courseContent() {
		System.out.println("JavaCourseMaterial.courseContent()");
		return "1.oops ,2.Exception handling ,3. Collections and etc..";
	}

	@Override
	public double price() {
		System.out.println("JavaCourseMaterial.price()");
		return 400;
	}

}
