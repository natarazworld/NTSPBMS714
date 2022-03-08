package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.IPLPlayerInfo;

public interface IIPLPlayerInfoRepo extends JpaRepository<IPLPlayerInfo, Integer> {

}
