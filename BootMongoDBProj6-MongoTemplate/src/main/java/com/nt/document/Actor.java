package com.nt.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
	@Id
	private Integer actorId;
	private String actorName;
	private  String category;
	private  Float  age;
	private  String actorAddrs;
	private  Long mobileNo;

}
