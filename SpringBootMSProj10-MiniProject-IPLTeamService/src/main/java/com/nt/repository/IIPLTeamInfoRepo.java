package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.IPLTeamInfo;

public interface IIPLTeamInfoRepo extends JpaRepository<IPLTeamInfo, Integer> {

}
