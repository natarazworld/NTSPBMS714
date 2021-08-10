package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.Player;
import com.nt.repo.IPlayerRepo;

@Service("sportsServices")
public class SportsManagementtServiceImpl implements ISportsManagementService {
	@Autowired
	private IPlayerRepo  playerRepo;
	

	@Override
	public String registerPlayer(Player player) {
		return "Payer is registred with the id ::"+playerRepo.save(player).getPid();
	}


	@Override
	public List<Player> getAllPayers() {
		return playerRepo.findAll(); 
	}

}
