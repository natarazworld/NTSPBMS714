//Product.java
package com.nt.model.prod;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="MDS_PRODUCT")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Integer pid;
	@NonNull
	@Column(length = 20)
	private String  pname;
	@NonNull
     private Double qty;
	@NonNull
	private Double price;

}
