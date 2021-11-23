package com.nt.basics;

public class Test {
	public Test() {
		System.out.println("Test: 0-param constuctir");
	}
	public void m1() {
		System.out.println("Test::m1()");
	}
	
	public static void main(String[] args) {
		  Test  t=new Test();
		  t.m1();
		  System.out.println("t obj class name::"+t.getClass()+" super class::"+t.getClass().getSuperclass());
		  System.out.println("=======================");
		  Test t1=new Test() { };
		  t1.m1();
		  System.out.println("t1 obj class name::"+t1.getClass()+"super class::"+t1.getClass().getSuperclass());
		  System.out.println("=======================");
		  Test t2=new Test() {
			      // consturctor can not defined here , so go for instance block
			  {
				  m1();
			  }
		  };
		  System.out.println("t2 object class name::"+t2.getClass()+" super class::"+t2.getClass().getSuperclass());
		  
	}

}
