//Model  class
package com.nt.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="EXAM_RESULT")
public class OExamResult {
	@Id
	private Integer id;
	private LocalDate  dob;
	private  Float percentage;
	private  Integer semester;
	
	

}
