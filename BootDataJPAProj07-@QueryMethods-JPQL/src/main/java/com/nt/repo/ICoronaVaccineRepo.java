package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.entity.CoronaVaccine;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {
      
	//@Query(" FROM com.nt.entity.CoronaVaccine WHERE  company=?1")
	//@Query(" FROM CoronaVaccine WHERE  company=?1")
	//@Query(" FROM CoronaVaccine as cv WHERE cv.company=?1")
	//@Query("SELECT cv FROM CoronaVaccine as cv WHERE cv.company=?1")
	//@Query("SELECT cv FROM CoronaVaccine as cv WHERE cv.company=?") throws -->java.lang.IllegalArgumentException: JDBC style parameters (?) are not supported for JP
	/*	@Query("FROM CoronaVaccine  WHERE company=:vendor")
		public List<CoronaVaccine>  searchVaccinesByCompany(String vendor);*/
	
	@Query("FROM CoronaVaccine  WHERE company=:comp")
	public List<CoronaVaccine>  searchVaccinesByCompany(@Param("comp")String vendor);
}
