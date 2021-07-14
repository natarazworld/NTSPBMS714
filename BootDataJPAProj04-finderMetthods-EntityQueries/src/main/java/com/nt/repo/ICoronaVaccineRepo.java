package com.nt.repo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.CoronaVaccine;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {
	    // SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT
	       //   FROM CORNA_VACCINE WHERE COMPANY=?
         //public List<CoronaVaccine>  findByCompany(String company);
	       //public List<CoronaVaccine>  findByCompanyEquals(String company);
	       public List<CoronaVaccine>  findByCompanyIs(String company1);
	       
	       // SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT
	       //   FROM CORNA_VACCINE WHERE PRICE<?
	       public List<CoronaVaccine> findByPriceLessThan(double price);
	       
	       // SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT
	       //   FROM CORNA_VACCINE WHERE PRICE BETWEEN ? AND ?
	       public List<CoronaVaccine>  findByPriceBetween(double startPrice, double endPrice);
	       
	       // SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT        FROM CORNA_VACCINE WHERE NAME LIKE  'p%'
	    // SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT        FROM CORNA_VACCINE WHERE NAME LIKE  '_____'
	       public  List<CoronaVaccine>  findByNameLike(String initChars );
	       
	       // SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT        FROM CORNA_VACCINE WHERE NAME LIKE  'p%'
	       public  List<CoronaVaccine>  findByNameStartingWith(String startLetters );
	       
	       // SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT        FROM CORNA_VACCINE WHERE NAME LIKE  '%na'
	       public  List<CoronaVaccine>  findByNameEndingWith(String endtLetters );
	       // SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT        FROM CORNA_VACCINE WHERE NAME LIKE  '%e%'
	       public  List<CoronaVaccine> findByNameContaining(String letters);

	       // SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT        FROM CORNA_VACCINE WHERE COUNTRY IN('india','russia','usa')
	       public  List<CoronaVaccine> findByCountryIn(List<String> countries);
	       
	    // SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT        FROM CORNA_VACCINE WHERE COUNTRY NOT IN('china','pakistan')
	       public  List<CoronaVaccine> findByCountryNotIn(List<String> countries);
		    // SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT        FROM CORNA_VACCINE WHERE PRICE>400  ORDER BY PRICE ASC
	       public  List<CoronaVaccine> findByPriceGreaterThanOrderByPriceAsc(double startPrice);

	       // SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT        FROM CORNA_VACCINE WHERE COUNTRY <> 'china'
	       public  List<CoronaVaccine> findByCountryIsNot(String country);
	       //public  List<CoronaVaccine> findByCountryNot(String country);
	       //SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT        FROM CORNA_VACCINE WHERE REG_NO=?
	       public Optional<CoronaVaccine>  findByRegNo(Long regNo);
	       //=======================Using multiple properties based conditions=====================

	       //SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT        FROM CORNA_VACCINE WHERE NAME=? AND COUNTRY=?
	       //public  List<CoronaVaccine>  findByNameAndCountry(String name,String country); (or)  
	       public  List<CoronaVaccine>  findByNameEqualsAndCountryEquals(String name,String country);  
	       
	       //SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT        FROM CORNA_VACCINE WHERE NAME  LIKE 'p%' AND PRICE BETWEEN 400 AND 600
	       public  List<CoronaVaccine>  findByNameLikeOrPriceBetween(String nameInitChars,double startRange, double endRange);  
	       
	     //SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT        FROM CORNA_VACCINE WHERE COUNTRY IN(?,?,?)   AND PRICE BETWEEN ? AND ?
	       public  List<CoronaVaccine>  findByCountryInAndPriceBetween(Collection<String> countries,double startRange, double endRange);
	       
	     //SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT        FROM CORNA_VACCINE WHERE (COUNTRY IN(?,?,?)   AND  NAME IN(?,?,?)) OR PRICE >=?
	       public  List<CoronaVaccine>  findByCountryInAndNameInOrPriceGreaterThanEqual(Collection<String> countries,Collection<String> names, double priceStartRange);
	       
	       
	       

	       
	       
}
