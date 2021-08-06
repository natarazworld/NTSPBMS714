package com.nt.service;

import java.util.List;

import com.nt.document.PersonDetails;

public interface IPersonDetailsMgmtService {
         public  String registerPerson(PersonDetails details);
         public  List<PersonDetails>  fetchAllPersons();
}
