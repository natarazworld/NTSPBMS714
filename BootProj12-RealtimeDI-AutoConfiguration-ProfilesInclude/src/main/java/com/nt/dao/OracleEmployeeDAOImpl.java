package com.nt.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO2")
@Profile({"uat","prod"})
public class OracleEmployeeDAOImpl implements IEmployeeDAO {
	private static final String GET_EMPS_BY_DEGS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO,MGR FROM EMP  WHERE JOB IN";
	@Autowired
	private  DataSource  ds;
	
	public OracleEmployeeDAOImpl() {
		System.out.println("OracleEmployeeDAOImpl.::0-param constructor");
	}

	@Override
	public List<EmployeeBO> getEmpsByDesg(String cond) throws Exception {
		 List<EmployeeBO> listBO=null;
		 System.out.println("DataSource obj class name::"+ds.getClass());
		try(  //get pooled jdbc con   
				Connection con=ds.getConnection();
				  // create STatement object
				Statement st=con.createStatement(); // preparedSTatement object can not used here becoz no.of desgs is dynamic value
			   //send and execute SQL query in Db s/w
				// select empno,ename,job,sal,deptno,mgr  from emp where job in('CLERK','MANAGER') order by job
				 ResultSet rs=st.executeQuery(GET_EMPS_BY_DEGS+cond+" ORDER BY JOB");
				){
			 //convert RS object records to List of BO class objs
			 listBO=new ArrayList();
			 EmployeeBO bo=null;
			 while(rs.next()) {
				 //copy each record of RS to a object of EmployeeBO class
				  bo=new EmployeeBO();
				 bo.setEmpNo(rs.getInt(1));
				 bo.setEname(rs.getString(2));
				 bo.setJob(rs.getString(3));
				 bo.setSal(rs.getDouble(4));
				 bo.setDeptNo(rs.getInt(5));
				 bo.setMgrNo(rs.getInt(6));
				 //add each object of EmpoyeeBO to  List Collection
				 listBO.add(bo);
			 }//while
		}//try   // RS, ST, Con object will be closed here automaticlly..
		catch(SQLException se) {
			se.printStackTrace();
			throw se;  //for Exception  propagation
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return listBO;
	}//method

}//class
