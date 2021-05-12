package com.nt.comp;

import org.springframework.stereotype.Component;

@Component("fFlight")
public final class FirstFlight implements Courier {
	
	public FirstFlight() {
		System.out.println("FirstFlight:: 0-param constructor");
	}

	@Override
	public String deliver(int oid) {
         return  "Delivering "+oid+" order Id  order products using FirstFlight ";
	}

}
