package com.nt.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Setter
@Getter
public class Medal {
	@Id
	private String id;
	private MedalType type;
	private  String sportName;
	private  Double prizeMoney;
	private  String eventName;
	public Medal() {
		System.out.println("Medal:: 0-param constructor");
	}
	
	@Override
	public String toString() {
		return "Medal [id=" + id + ", type=" + type + ", sportName=" + sportName + ", prizeMoney=" + prizeMoney + ", eventName="
				+ eventName + "]";
	}
	
	
	

}
