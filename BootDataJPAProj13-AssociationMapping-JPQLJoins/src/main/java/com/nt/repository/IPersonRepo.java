package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Person;

public interface IPersonRepo extends JpaRepository<Person,Integer> {

	//@Query("SELECT p.pid,p.pname,p.paddrs,ph.regno,ph.phoneNo,ph.provider,ph.type from Person p inner join p.contactDetails  ph")
	//@Query("SELECT p.pid,p.pname,p.paddrs,ph.regno,ph.phoneNo,ph.provider,ph.type from Person p right join p.contactDetails  ph")
	//@Query("SELECT p.pid,p.pname,p.paddrs,ph.regno,ph.phoneNo,ph.provider,ph.type from Person p left join p.contactDetails  ph")
	@Query("SELECT p.pid,p.pname,p.paddrs,ph.regno,ph.phoneNo,ph.provider,ph.type from Person p full join p.contactDetails  ph")
	public   List<Object[]>  fetchDataUsingJoinsByParent();
}
