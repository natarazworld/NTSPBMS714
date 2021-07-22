package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
//@Table(name="CORONA_VACCINE_TAB")  optional  if u want to db table name same as entiyt class name
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class CoronaVaccine implements Serializable {
	
	@Id  //To make  property as singulr ID property and to map with singular PK column
	//@Column(name="regNo") optional if want to take property name as the column name
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Long regNo;
	@NonNull
	@Column(length = 20)
	private  String name;
	@NonNull
	@Column(length = 20)
	private  String company;
	@NonNull
	@Column(length = 20)
	private  String country;
	@NonNull
	private  Double price;
	@NonNull
	private   Integer requiredDoseCount;
	
	/*public CoronaVaccine(Integer requiredDoseCount) {
			this.requiredDoseCount=requiredDoseCount;
		}*/

}
