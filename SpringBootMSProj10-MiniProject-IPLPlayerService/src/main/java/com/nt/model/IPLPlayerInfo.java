package com.nt.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class IPLPlayerInfo {
	@Id
	@GeneratedValue
	private Integer pid;
	@Column(length=20)
	private String  pname;
	@Column(length=20)
	private  String role;
	private Integer jersyNo;
	@ManyToOne(targetEntity = IPLTeamInfo.class,cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name = "team_id",referencedColumnName = "teamId")
	private  IPLTeamInfo team;

}
