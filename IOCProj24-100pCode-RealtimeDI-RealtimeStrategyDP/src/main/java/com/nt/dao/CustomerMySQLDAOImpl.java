package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.nt.bo.CustomerBO;

@Repository("custMySQLDAO")
public final class CustomerMySQLDAOImpl implements ICustomerDAO {
	private  static final String  REALTIMEDI_CUSTOMER_INSERT_QUERY="INSERT INTO REALTIMEDI_CUSTOMER(CUSTNAME,CUSTADDRS,PAMT,RATE,TIME,INTRAMOUNT) VALUES(?,?,?,?,?,?)";
	@Autowired
	@Qualifier("mysqlDs")
	private DataSource ds;



	@Override
	public int insert(CustomerBO bo) throws Exception {
		int count=0;
		//get Pooled jdbc con object and creatd PreparedStatement obj
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(REALTIMEDI_CUSTOMER_INSERT_QUERY)	){   //try with resource
			//set query param values
			ps.setString(1, bo.getCustName());
			ps.setString(2, bo.getCustAddrs());
			ps.setFloat(3,bo.getPamt());
			ps.setFloat(4,bo.getRate());
			ps.setFloat(5,bo.getTime());
			ps.setFloat(6,bo.getIntrestAmount());
			//execute the Query
			count=ps.executeUpdate();
		}//try
		catch(SQLException se) {
			se.printStackTrace();
			throw se;  // Exception rethrowing
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;  //  Exception rethrowing
		}
		return count;
	}

}
