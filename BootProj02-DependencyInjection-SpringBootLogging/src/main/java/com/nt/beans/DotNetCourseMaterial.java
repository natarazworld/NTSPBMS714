package com.nt.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("dotNet")
//@Primary
public final class DotNetCourseMaterial implements ICourseMaterial {
	
	public DotNetCourseMaterial() {
		System.out.println("DotNetCourseMaterial:: 0-param constructor");
	}

	@Override
	public String courseContent() {
		System.out.println("DotNetCourseMaterial.courseContent()");
		return "1.c# oops ,2.c# Exception handling ,3.c# Collections  and etc..";
	}

	@Override
	public double price() {
		System.out.println("DotNetCourseMaterial.price()");
		return 300;
	}

}
