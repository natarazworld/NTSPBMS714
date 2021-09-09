package com.nt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="emp")
@Data
public class Employee {
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "emp_no_seq1",initialValue =3000,allocationSize = 1 )
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer empno;
	private  String ename;
	private  String job;
	private  Float sal;
	private  Integer deptno=10;

}
