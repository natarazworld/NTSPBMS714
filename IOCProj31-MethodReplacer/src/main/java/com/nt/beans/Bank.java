package com.nt.beans;

public  class Bank {
      public  final   double   calculateIntrestAmount(double pamt,double rate, double time) {
    	  System.out.println("Bank.calculateIntrestAmount()");
    	     return     (pamt* Math.pow(1+rate/100,time))-pamt;
      }
}
