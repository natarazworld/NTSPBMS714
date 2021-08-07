package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.DrivingLicense;

public interface IDrivingLicenseRepo extends MongoRepository<DrivingLicense,Long> {

}
