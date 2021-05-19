package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.nt.bo.CustomerBO;

@Repository("custOraDAO")
public final class CustomerOracleDAOImpl implements ICustomerDAO {
	private  static final String  REALTIMEDI_CUSTOMER_INSERT_QUERY="INSERT INTO REALTIMEDI_CUSTOMER VALUES(CUSTID_SEQ.NEXTVAL,?,?,?,?,?,?)";
	@Autowired
	private DataSource ds;



	@Override
	public int insert(CustomerBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		try {
			//get pooled jdbc con object
			con=ds.getConnection();
			//create PreparedStaement object having pre-compiled SQL query
			ps=con.prepareStatement(REALTIMEDI_CUSTOMER_INSERT_QUERY);
			//set query param values
			ps.setString(1, bo.getCustName());
			ps.setString(2, bo.getCustAddrs());
			ps.setFloat(3,bo.getPamt());
			ps.setFloat(5,bo.getRate());
			ps.setFloat(4,bo.getTime());
			ps.setFloat(6,bo.getIntrestAmount());
			//execute the Query
			count=ps.executeUpdate();
		}
		catch(SQLException se) {
			se.printStackTrace();
			throw se;  // Exception rethrowing
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;  //  Exception rethrowing
		}
		finally {
			//close jdbc objs
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
				throw se;
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
				throw se;
			}
		}//finally
	
		return count;
	}

}
