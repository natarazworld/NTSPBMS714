package com.nt.runner;

import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.Medal;
import com.nt.document.MedalType;
import com.nt.document.Player;
import com.nt.document.Sport;
import com.nt.service.ISportsManagementService;

@Component
public class AssociationsTestRunner  implements  CommandLineRunner {
	@Autowired
	private  ISportsManagementService  service;
	
	 @Override
	public void run(String... args) throws Exception {
		/* //prepare object
		  //parent object
		   Player player=new Player();
		   player.setPid(new Random().nextInt(100000));
		   player.setPname("p.v.sindhu");
		   player.setPaddrs("hyd");
		   player.setCountry("india");
		   
		   //child objects -1
		   Sport sport1=new Sport();
		   sport1.setId(Long.valueOf(new Random().nextInt(100000)));
		   sport1.setName("batminton");
		   sport1.setOlympicSport(true);
		   sport1.setTeamSport(false);
		   sport1.setKitItems(new String[] {"bat","cock","net"});
		   Sport sport2=new Sport();
		   sport2.setId(Long.valueOf(new Random().nextInt(100000)));
		   sport2.setName("cricket");
		   sport2.setOlympicSport(false);
		   sport2.setTeamSport(true);
		   sport2.setKitItems(new String[] {"bat","ball","wickets","gloves","pads","helmet"});
		   //child objects -2
		   Medal medal1=new Medal();
		   medal1.setId(UUID.randomUUID().toString().replace("-","").substring(0,10));
		   medal1.setType(MedalType.BRONZE);
		   medal1.setPrizeMoney(10000000.0);
		   medal1.setSportName("batminton");
		   medal1.setEventName("Tokyo-Olympics-2021");
		   Medal medal2=new Medal();
		   medal2.setId(UUID.randomUUID().toString().replace("-","").substring(0,10));
		   medal2.setType(MedalType.SILVER);
		   medal2.setPrizeMoney(5000000.0);
		   medal2.setSportName("batminton");
		   medal2.setEventName("RIO-Olympics-2016");
		   //set childs to parent
		   player.setSports(Set.of(sport1,sport2));
		   player.setMedals(Map.of("Tokyo-Bronze",medal1,
				                                              "RIO-Silver",medal2));
		   try {
		   //invoke method
		   System.out.println(service.registerPlayer(player));
		   }
		   catch(Exception e) {
			   e.printStackTrace();
		   }*/
		  service.getAllPayers().forEach(player->{
			  System.out.println("parent::"+player);
			  Set<Sport> sportsSet=player.getSports();
			  sportsSet.forEach(sport->{
				  System.out.println("child1:"+sport);
			  });
			  Map<String,Medal> medalsMap=player.getMedals();
			  medalsMap.forEach((name,medal)->{
				  System.out.println("child2:"+name+"===="+medal);
			  });
		  });
	}//run
}//class
