package com.nt.service;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;

public interface IPersonMgmtService {
     public   String  savePerson(Person per);
     public   String  savePhoneNumbers(Iterable<PhoneNumber> phones);
     public   Iterable<Person>  fetchByPerson();
     public  Iterable<PhoneNumber> fetchByPhoneNumber();
     public  String  deleteByPerson(int personId);
     public  String  deleteAllPhoneNumbersOfAPerson(int personId);
}
