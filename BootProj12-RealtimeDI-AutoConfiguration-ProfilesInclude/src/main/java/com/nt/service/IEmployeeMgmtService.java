package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface IEmployeeMgmtService {
    public List<EmployeeDTO>  fetchEmpsByDesgs(String desgs[])throws Exception;
}
