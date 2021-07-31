//PhoneNumber.java
package com.nt.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="OTM_PHONENUMBER")
@AllArgsConstructor
@RequiredArgsConstructor

public class PhoneNumber implements Serializable {
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "regno_seq",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="gen1" )
    private  Long regno;
	@NonNull
	private  Long phoneNo;
	@Column(length=20)
	@NonNull
	private  String provider;
	@Column(length=20)
	@NonNull
	private  String type;
	@ManyToOne(targetEntity = Person.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_ID",referencedColumnName = "PID") // FK column
		private  Person  person;  //for Many To One
	
	public PhoneNumber() {
		System.out.println("PhoneNumber:: 0-param constructor"+this.getClass());
	}

	@Override
	public String toString() {
		return "PhoneNumber [regno=" + regno + ", phoneNo=" + phoneNo + ", provider=" + provider + ", type=" + type
				+ "]";
	}
	
	
	
}
