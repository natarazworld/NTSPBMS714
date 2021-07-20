package com.nt.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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
	
	//==================Select Queries performing Bulk opeations ===========
	
	// Entity query selecting all column values
	 @Query("FROM CoronaVaccine WHERE company IN(:comp1,:comp2,:comp3) ORDER BY company")
	 public List<CoronaVaccine> searchVaccinesByCompanies(String comp1,String comp2,String comp3 );  
	                   // Here  we can not take  List<String> , String ... companies (var args)/String [] companies(String) as the param types
	 
	 //Scalar query selecting specific multiple col vlaues
	 @Query("SELECT name,company,price FROM CoronaVaccine WHERE name IN(:name1,:name2)")
	  public  List<Object[]> searchVaccineDetailsByNames(String name1,String name2);
	  
	  @Query("SELECT name FROM CoronaVaccine WHERE price BETWEEN  :min AND :max")
	  public  List<String> searchVaccineNamesByPriceRange(double min,double max);
	  
	  //=====================Select Query performing Single Row Operation====================
	 //Entity Query giving single row
	  @Query("FROM CoronaVaccine  WHERE name=:vname")
	  public Optional<CoronaVaccine>  searchVaccineByName(String vname);
	  
	  //Scalar query giving specific multiple col values of single row
	  @Query("SELECT  name,company,country FROM CoronaVaccine  WHERE name=:vname")
	   public  Object searchVaccineDataByName(String vname);
	  
	  //Scalar Query giving specific single col value
	  @Query("SELECT  country FROM CoronaVaccine  WHERE name=:vname")
	  public  String searchVaccineCountryByName(String vname);
	  //========================== aggregate functions ================
	  @Query("SELECT COUNT(*) FROM CoronaVaccine")
	   public  long   getVaccinesCount();
	  @Query("SELECT COUNT(*),MAX(price),MIN(price),SUM(price),AVG(price) FROM CoronaVaccine WHERE price>=:min AND price<=:max ")
	  public Object  getVaccinesAggregateDataByPriceRange(double min,double max);
	  //======================== NON- select opeations(DML Operations)=================
	  @Modifying
	  @Query("UPDATE CoronaVaccine SET price=:newPrice WHERE country=:country")
	  @Transactional
	  public  int   updatePriceByCountry(double newPrice, String country);
	  
	
}
