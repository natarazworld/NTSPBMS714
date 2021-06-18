package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("company1")
public class CompanyDetails1 {
	@Value("${org.nit.name}")
	private  String  title;
	@Value("${org.nit.type}")
	private String  type;
	@Value("${org.nit.location}")
	private String addrs;
	
	@Override
	public String toString() {
		return "CompanyDetails1 [title=" + title + ", type=" + type + ", addrs=" + addrs + "]";
	}
	
	
}
