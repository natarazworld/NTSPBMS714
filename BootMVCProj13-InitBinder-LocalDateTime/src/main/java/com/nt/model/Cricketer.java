package com.nt.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="CRICKETER_INFO_LDT")
@Data
public class Cricketer {
	@Id
	@GeneratedValue
	private Integer cid;
	@Column(length= 20)
    private  String name;
	@Column(length= 20)
    private   String type;
    private  LocalDate   dob;
    private  LocalTime   tob;
    private  LocalDateTime  doj;
    
}
