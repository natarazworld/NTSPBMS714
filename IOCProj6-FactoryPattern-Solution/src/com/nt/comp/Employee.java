package com.nt.comp;

public class Employee extends Person {
    private  String desg;
    private  float salary;
    //HAS-A property (Composition)
    private  Food  food;
    
    public Employee(Food food) {
    	System.out.println("Employee:: 1 -param constructor");
		   this.food=food;
	}
    
    
	@Override
	public void work() {
		System.out.println("Employee is working on Software Development and taking"+food);
	}

}
