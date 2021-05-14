package com.nt.comp1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.nt.comp.Courier;

@Component("fFlight")
public final class FirstFlight implements Courier {
	@Value("${fpt.info.url}")
	private String crUrl;
	
	public FirstFlight() {
		System.out.println("FirstFlight:: 0-param constructor");
	}

	@Override
	public String deliver(int oid) {
         return  "Delivering "+oid+" order Id  order products using FirstFlight-----> "+crUrl;
	}

}
