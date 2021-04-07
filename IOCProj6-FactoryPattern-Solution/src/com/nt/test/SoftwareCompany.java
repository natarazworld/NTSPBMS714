package com.nt.test;

import com.nt.comp.Person;
import com.nt.factory.PersonFactory;

public class SoftwareCompany {

	public static void main(String[] args) {
	     //Software company needs  Employee
		 Person  per=PersonFactory.getPerson("emp");   
		  per.work();

	}

}
