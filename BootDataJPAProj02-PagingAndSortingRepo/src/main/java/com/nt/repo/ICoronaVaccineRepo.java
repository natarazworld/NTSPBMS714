package com.nt.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.CoronaVaccine;

public interface ICoronaVaccineRepo extends PagingAndSortingRepository<CoronaVaccine, Long> {

}
