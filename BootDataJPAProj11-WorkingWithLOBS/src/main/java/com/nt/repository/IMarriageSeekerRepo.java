package com.nt.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.MarriageSeeker;

public interface IMarriageSeekerRepo extends PagingAndSortingRepository<MarriageSeeker, Long>{
	

}
