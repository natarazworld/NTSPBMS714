//Model and Document  class
package com.nt.document;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamResult {
	@Id
	private Integer id;
	private String  dob;
	private  Float percentage;
	private  Integer semester;
	
	

}
