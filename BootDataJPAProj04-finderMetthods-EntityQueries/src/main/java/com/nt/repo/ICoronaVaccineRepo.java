package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.CoronaVaccine;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {
	    // SELECT REG_NO,NAME,COMPANY,PRICE,COUNTRY,REQUIRED_DOSE_COUNT
	       //   FROM CORNA_VACCINE WHERE COMPANY=?
         //public List<CoronaVaccine>  findByCompany(String company);
	       //public List<CoronaVaccine>  findByCompanyEquals(String company);
	       public List<CoronaVaccine>  findByCompanyIs(String company1);
}
