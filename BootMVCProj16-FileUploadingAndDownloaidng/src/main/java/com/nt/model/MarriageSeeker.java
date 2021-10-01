package com.nt.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MarriageSeeker {
	private  String profileName;
	private  String gender="female";
	private  MultipartFile  resume;
	private  MultipartFile   photo;
	

}
