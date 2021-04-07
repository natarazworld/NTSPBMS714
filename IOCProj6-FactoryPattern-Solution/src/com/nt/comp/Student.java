package com.nt.comp;

public class Student  extends  Person {
  private   int rollNo;
  private String course;
  private Food  food;
  
  public Student(Food food) {
	  System.out.println("Student:: 1-param constructor");
      this.food=food;
   }
	@Override
	public void work() {
		System.out.println("Student is studying  B.Tech (CS) and taking  "+food);
	}
	
	

}
