package com.nt.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.Sport;

public interface ISportRepo extends MongoRepository<Sport, Long> {
     
}
