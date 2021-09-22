package com.nt.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nt.model.HumanActivities;

public interface IHumanActiviesRepo extends CrudRepository<HumanActivities, String>  {
     
	@Query("SELECT hobbies FROM HumanActivities")
	public Set<String> getAllHobbies();
}
