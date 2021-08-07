package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.Person;

public interface IPersonRepo extends MongoRepository<Person, Integer> {

}
