package com.nt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="IPL_TEAM_INFO")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IPLTeamInfo {
	 @Id
	 @SequenceGenerator(name="gen1",sequenceName = "TEAM_ID_SEQ",initialValue = 1000 ,allocationSize = 1)
	 @GeneratedValue(generator = "gen1",strategy =GenerationType.SEQUENCE )
	private  Integer teamId;
    private String teamName;
    private String location;
    private  String  owner;
    private  String captain;

}
