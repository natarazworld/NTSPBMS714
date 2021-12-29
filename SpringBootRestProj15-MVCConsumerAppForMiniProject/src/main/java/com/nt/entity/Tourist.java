package com.nt.entity;

import java.io.Serializable;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Tourist  implements Serializable {
	private  Integer tid;
	@NonNull
	private String name;
	@NonNull
	private  String  city;
	@NonNull
	private  String packageType;
	@NonNull
	private  Double budget; 

}
