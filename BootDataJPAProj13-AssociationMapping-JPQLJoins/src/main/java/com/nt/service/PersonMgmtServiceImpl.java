package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.repository.IPersonRepo;
import com.nt.repository.IPhoneNumberRepo;

@Service("personService")
public class PersonMgmtServiceImpl implements IPersonMgmtService {
	@Autowired
	private  IPersonRepo  perRepo;
	@Autowired
	private  IPhoneNumberRepo  phoneRepo;

		@Override
		public List<Object[]> fetchDataByJoinsUsingParent() {
			return perRepo.fetchDataUsingJoinsByParent();
		}

}
