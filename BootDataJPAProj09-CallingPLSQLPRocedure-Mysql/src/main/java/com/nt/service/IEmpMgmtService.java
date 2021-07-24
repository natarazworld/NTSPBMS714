package com.nt.service;

import java.util.List;

import com.nt.entity.Emp;

public interface IEmpMgmtService {
    public  List<Emp>  searchEmpsByDesgs(String desg1,String desg2);
    
}
