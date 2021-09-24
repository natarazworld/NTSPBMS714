package com.nt.service;

import java.util.List;
import java.util.Set;

public interface ICustomerMgmtService {
    public  Set<String>  getAllCountries();
    public  Set<String> getAllLanguages();
    public  Set<String> getAllHobbies();
    public  List<String> getStatesByCountry(String country);
}
