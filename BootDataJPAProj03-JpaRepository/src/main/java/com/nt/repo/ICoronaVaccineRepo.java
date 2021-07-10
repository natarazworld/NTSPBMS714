package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.CoronaVaccine;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {

}
