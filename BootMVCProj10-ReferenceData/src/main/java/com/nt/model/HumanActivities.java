package com.nt.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HUMAN_ACTIVITIES")
public class HumanActivities {
	@Id
  private String hobbies;
}
