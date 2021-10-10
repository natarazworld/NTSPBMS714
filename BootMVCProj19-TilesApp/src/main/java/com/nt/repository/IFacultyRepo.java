package com.nt.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.model.Faculty;

public interface IFacultyRepo extends PagingAndSortingRepository<Faculty,Integer> {

}
