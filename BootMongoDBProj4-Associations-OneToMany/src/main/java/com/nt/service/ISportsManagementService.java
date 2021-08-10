package com.nt.service;

import java.util.List;

import com.nt.document.Player;

public interface ISportsManagementService {
     public   String registerPlayer(Player palyer);
     public   List<Player>  getAllPayers();
}
