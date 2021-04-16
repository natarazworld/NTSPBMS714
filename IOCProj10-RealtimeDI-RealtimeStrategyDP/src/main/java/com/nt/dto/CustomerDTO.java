package com.nt.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable {
	 private String custName;
	    private String custAddrs;
	    private  Float   pamt;
	    private  Float   rate;
	    private Float time;
	    //setter and getters  (alt+shift+s ,r  ->select all)
		public String getCustName() {
			return custName;
		}
		public void setCustName(String custName) {
			this.custName = custName;
		}
		public String getCustAddrs() {
			return custAddrs;
		}
		public void setCustAddrs(String custAddrs) {
			this.custAddrs = custAddrs;
		}
		public Float getPamt() {
			return pamt;
		}
		public void setPamt(Float pamt) {
			this.pamt = pamt;
		}
		public Float getRate() {
			return rate;
		}
		public void setRate(Float rate) {
			this.rate = rate;
		}
		public Float getTime() {
			return time;
		}
		public void setTime(Float time) {
			this.time = time;
		}
		
	    
		//toString
		@Override
		public String toString() {
			return "CustomerDTO [custName=" + custName + ", custAddrs=" + custAddrs + ", pamt=" + pamt + ", rate="
					+ rate + ", time=" + time + "]";
		}

}
