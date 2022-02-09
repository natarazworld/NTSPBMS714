package com.nt.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorInfo implements Serializable {
	private  Integer actorId;
	private String actorName;
	private String actorAddrs;

}
