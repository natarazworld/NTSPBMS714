package com.nt.comp;

import org.springframework.stereotype.Component;

@Component("bDart")
public final class BlueDart implements Courier {
	
	public BlueDart() {
		System.out.println("BlueDart:: 0-param constructor");
	}

	@Override
	public String deliver(int oid) {
         return  "Delivering "+oid+" order Id  order products using BlueDart ";
	}

}
