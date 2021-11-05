package com.nt.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Table(name="SECURITY_USERS")
@Entity
@Data
public class UserDetails {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer unid;
	@Column(length = 20,unique = true,nullable = false)
	private String uname;
	@Column(length = 150,nullable = false)
	private String  pwd;
	@Column(length = 20,nullable = false)
	private String email;
	private  Boolean  status=true;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name ="SECURITY_ROLES",
	                                    joinColumns = @JoinColumn(name="USER_ID",referencedColumnName = "unid"))
	@Column(name="role")
	private Set<String> roles;

}
