package com.nt.comp;

public final class DTDC implements Courier {
	
	public DTDC() {
		System.out.println("DTDC:: 0-param constructor");
	}

	@Override
	public String deliver(int oid) {
         return  "Delivering "+oid+" order Id  order products using DTDC ";
	}

}
