package com.nt.runner;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.service.IPersonMgmtService;

@Component
public class AssociationTestRunner implements CommandLineRunner {
	@Autowired
	private IPersonMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		/* // === save operation parent to child ========
		//parepare obj having  associcated child objs
		  //child objs 
		PhoneNumber ph1=new PhoneNumber(9999999L,"airtel","office");
		 PhoneNumber ph2=new PhoneNumber(8888888L,"vodafone","residence");
		 //parent obj
		  Person person1=new Person("rajesh","hyd");
		 //parent to childs
		  ph1.setPerson(person1);
		  ph2.setPerson(person1);
		 Set<PhoneNumber> phonesSet=Set.of(ph1,ph2);
		 
			    //childs to  parent
			  person1.setContactDetails(phonesSet);
			  //inovoke service method
			  System.out.println(service.savePerson(person1)); */
		
		   //================= Save operation child to parent ===============
		     //child objs  
		   PhoneNumber ph1=new PhoneNumber(76576757L,"jio","office" );
		     PhoneNumber ph2=new PhoneNumber(66576155L,"vodafone","office" );
		     //parent obj
		      Person per=new Person("karan","hyd");
		       //add parent to childs 
		        ph1.setPerson(per); ph2.setPerson(per);
		        //childs to parent
		        Set<PhoneNumber> phonesSet=Set.of(ph1,ph2);
		      per.setContactDetails(phonesSet);
		      
		      System.out.println(service.savePhoneNumbers(phonesSet));

		/*		  //================= Load operation  parent to child ===============
				   service.fetchByPerson().forEach(per->{
					   System.out.println("parent:::"+per);
						 Set<PhoneNumber> childs=per.getContactDetails();
						 childs.forEach(ph->{
						   System.out.println("child ::"+ph);
						 });
				   });
		*/

		// ================= Load operation child to parent ===============
		/*service.fetchByPhoneNumber().forEach(ph->{
			 System.out.println("child::"+ph);
			Person per=ph.getPerson();
			System.out.println("parent:"+per);
		});
		*/
		 // ==============  delete Operation  parent to child ============
		 //System.out.println(service.deleteByPerson(23));
		 //System.out.println(service.deleteAllPhoneNumbersOfAPerson(28));

	}// run
}// class
