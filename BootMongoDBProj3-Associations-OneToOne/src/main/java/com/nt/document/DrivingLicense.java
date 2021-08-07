package com.nt.document;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
public class DrivingLicense {
	@Id
	private  Long lid;
	private  String type;
	private  LocalDateTime expiryDate;
	private  Person person;
	
	public DrivingLicense() {
		System.out.println("DrivingLicense:: 0-param constructor");
	}
	
	@Override
	public String toString() {
		return "DrivingLicense [lid=" + lid + ", type=" + type + ", expiryDate=" + expiryDate + "]";
	}
	
	
	
	
}
