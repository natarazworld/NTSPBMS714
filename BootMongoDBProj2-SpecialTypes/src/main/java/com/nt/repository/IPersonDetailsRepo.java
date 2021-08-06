package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.PersonDetails;

public interface IPersonDetailsRepo extends MongoRepository<PersonDetails, Integer> {

}
