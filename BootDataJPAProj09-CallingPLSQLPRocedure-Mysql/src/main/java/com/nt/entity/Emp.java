package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="EMP") // optional  if u want to db table name same as entiyt class name
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp implements Serializable {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="empno")
	private  Long empNo;
	@Column(length = 20)
	private  String ename;
	@Column(length = 20)
	private  String job;
	@Column(length = 20)
	private  Float  sal;

}
