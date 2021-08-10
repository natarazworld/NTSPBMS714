package com.nt.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.Medal;

public interface IMedalRepo extends MongoRepository<Medal, String> {

}
