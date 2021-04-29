package com.nt.comp;

public final class FedEx implements Courier {
	
	public FedEx() {
		System.out.println("FedEx:: 0-param constructor");
	}

	@Override
	public String deliver(int oid) {
         return  "Delivering "+oid+" order Id  order products using FedEx ";
	}

}
