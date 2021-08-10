package com.nt.document;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Setter
@Getter
public class Sport {
	@Id
	private  Long id;
	private  String name;
	private boolean teamSport;
	private boolean isOlympicSport;
	private String[]  kitItems;
	
	public Sport() {
		System.out.println("Sport:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "Sport [id=" + id + ", name=" + name + ", teamSport=" + teamSport + ", isOlympicSport=" + isOlympicSport
				+ ", kitItems=" + Arrays.toString(kitItems) + "]";
	}
	
	

}
