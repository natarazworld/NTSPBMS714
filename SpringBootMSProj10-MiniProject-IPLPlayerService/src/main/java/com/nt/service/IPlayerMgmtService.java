package com.nt.service;

import java.util.List;

import com.nt.model.IPLPlayerInfo;

public interface IPlayerMgmtService {
	public  String  registerPlayer(IPLPlayerInfo player);
	public   List<IPLPlayerInfo>   findAllPlayerInfo();

}
