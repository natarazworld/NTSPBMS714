package com.nt.document;

import java.util.Map;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Setter
@Getter
public class Player {
	@Id
	private Integer pid;
	private String  pname;
	private String  paddrs;
	private  String country;
	private Set<Sport> sports;  //HAS- property for One To Many
	private Map<String,Medal> medals;  //HAS-A property for One To Many
	
	public Player() {
		System.out.println("Player:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "Player [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + ", country=" + country + "]";
	}
	
	

}
