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
	
	@Query("FROM CoronaVaccine  WHERE price>=?1 AND  price<=?2")
	//@Query("FROM CoronaVaccine  WHERE price>=:min AND  price<=:max")
	public  List<CoronaVaccine> searchVaccinesByPriceRange(double min, double max);
	
	// Entity query selecting all column values
	 @Query("FROM CoronaVaccine WHERE company IN(:comp1,:comp2,:comp3) ORDER BY company")
	 public List<CoronaVaccine> searchVaccinesByCompanies(String comp1,String comp2,String comp3 );  
	                   // Here  we can not take  List<String> , String ... companies (var args)/String [] companies(String) as the param types
	 
	 //Scalar query selecting specific multiple col vlaues
	 @Query("SELECT name,company,price FROM CoronaVaccine WHERE name IN(:name1,:name2)")
	  public  List<Object[]> searchVaccineDetailsByNames(String name1,String name2);
	  
	  @Query("SELECT name FROM CoronaVaccine WHERE price BETWEEN  :min AND :max")
	  public  List<String> searchVaccineNamesByPriceRange(double min,double max);
	  
	 
	 
	
}
