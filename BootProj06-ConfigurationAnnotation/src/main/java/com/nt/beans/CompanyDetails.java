package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("company")
@ConfigurationProperties(prefix = "org.nit")
@Data
public class CompanyDetails {
	private  String  name;
	private String  type;
	@Value("${my.app.addrs}")
	private String location="delhi";
	
	
	
	@Override
	public String toString() {
		return "CompanyDetails [name=" + name + ", type=" + type + ", location=" + location + "]";
	}
}
