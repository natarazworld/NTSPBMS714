//Model  class
package com.nt.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IExamResult {
	@Id
	private Integer id;
	private String  dob;
	private  Float percentage;
	private  Integer semester;
	
	

}
