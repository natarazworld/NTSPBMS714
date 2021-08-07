package com.nt.service;

import java.util.List;

import com.nt.document.DrivingLicense;
import com.nt.document.Person;

public interface IRtoMgmtService {
    public   String  savePersonWithLicense(Person person);
    public   String  saveLicenseWithPerson(DrivingLicense license);
    public  List<Person> fetchAllPersons();
    
}
