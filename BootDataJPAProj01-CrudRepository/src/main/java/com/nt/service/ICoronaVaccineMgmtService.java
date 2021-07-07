package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.CoronaVaccine;

public interface ICoronaVaccineMgmtService {
    public   String   registerVaccine(CoronaVaccine vaccine);
    public   Iterable<CoronaVaccine>  registerInBatch(Iterable<CoronaVaccine>  vaccines);
    public    long    getVaccinesCount();
    public  boolean   checkVaccineAvailabilityByRegNo(long regNo);
    public   Iterable<CoronaVaccine>  fetchAllDetails();
    public   Iterable<CoronaVaccine>  fetchAllDetailsByIds(List<Long> ids);
    public Optional<CoronaVaccine> fetchVaccineById(Long regNo);
}
