package com.nt.repo;

import org.springframework.data.repository.CrudRepository;

import com.nt.entity.CoronaVaccine;

public interface ICoronaVaccineRepo extends CrudRepository<CoronaVaccine, Long> {

}
