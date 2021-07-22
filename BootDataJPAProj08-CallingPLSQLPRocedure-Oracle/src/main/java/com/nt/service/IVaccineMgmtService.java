package com.nt.service;

import java.util.List;

import com.nt.entity.CoronaVaccine;

public interface IVaccineMgmtService {
    public  List<CoronaVaccine>  searchVaccinesByPriceRange(double min,double max);
}
