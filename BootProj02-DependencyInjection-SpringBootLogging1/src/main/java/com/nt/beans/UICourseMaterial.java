package com.nt.beans;

import org.springframework.stereotype.Component;

@Component("UI")
public final class UICourseMaterial implements ICourseMaterial {
	
	public UICourseMaterial() {
		System.out.println("UICourseMaterial:: 0-param constructor");
	}

	@Override
	public String courseContent() {
		System.out.println("UICourseMaterial.courseContent()");
		return "1.html ,2.java script ,3.css  and etc..";
	}

	@Override
	public double price() {
		System.out.println("UICourseMaterial.price()");
		return 200;
	}

}
