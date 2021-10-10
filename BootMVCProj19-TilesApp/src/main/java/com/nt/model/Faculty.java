package com.nt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="INFO_FACULTY")
public class Faculty {
	@Id
	@GeneratedValue
	private  Integer  fid;
	private  String  fname;
	private  String  qlfy;
	private  String subject;

}
