package com.nt.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamResult {
	private  Integer id;
	private  Date  dob;
	private  double percentage;
	private  Integer semester;

}
