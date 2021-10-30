package com.nt.repository;

import org.springframework.data.repository.CrudRepository;

import com.nt.model.UserDetails;

public interface IUserDetailsRepo extends CrudRepository<UserDetails,Integer > {

}
