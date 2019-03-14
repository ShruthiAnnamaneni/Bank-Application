package com.cg.bank.BankApplications.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cg.bank.BankApplications.bean.DetailsDTO;

public class TransactionDaoImpl implements TransactionDao{
	DetailsDTO details=new DetailsDTO();
    double balance,balance1,balance2,balance3,balance4;
    int i;
	public double withdraw(long accountNo,int withdrawAmount) {
		try {
		Class.forName("oracle:jdbc:driver:OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SHRUTHI","Annay@27");
		PreparedStatement ps=con.prepareStatement("select * from customer_details");
	    ResultSet rs=ps.executeQuery();
	    if(rs.getLong(1)==(accountNo)) {
	    	balance=rs.getDouble(10);
	    }
	    balance=balance-withdrawAmount;
	    PreparedStatement ps1=con.prepareStatement("update customer_details set balance=? where account_no=?");
	    ps1.setDouble(10,balance);
	    ps1.setLong(1,accountNo);
	    i=ps1.executeUpdate();
	    
		}catch(Exception e) {
			
		}
		return i;
	}

	public double deposit(long accountNo,int depositAmount) {
		try {
			Class.forName("oracle:jdbc:driver:OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SHRUTHI","Annay@27");
			PreparedStatement ps=con.prepareStatement("select * from customer_details");
		    ResultSet rs=ps.executeQuery();
		    if(rs.getLong(1)==(accountNo)) {
		    	balance1=rs.getDouble(10);
		    }
		    balance1=balance1+depositAmount;
		    PreparedStatement ps1=con.prepareStatement("update customer_details set balance=? where account_no=?");
		    ps1.setDouble(10,balance1);
		    ps1.setLong(1,accountNo);
		    i=ps1.executeUpdate();
		    
			}catch(Exception e) {
				
			}
		
		return i;
	}

	public double balance(long accountNo) {
		try {
			Class.forName("oracle:jdbc:driver:OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SHRUTHI","Annay@27");
			PreparedStatement ps=con.prepareStatement("select * from customer_details");
		    ResultSet rs=ps.executeQuery();
		    if(rs.getLong(1)==(accountNo)) {
		    	balance2=rs.getDouble(10);
		    }
		    
			}catch(Exception e) {
				
			}
		return balance2;
	}

	public int transfer(DetailsDTO details) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc.oracle:thin:@localhost:1521:xe","SHRUTHI","Annay@27");
			PreparedStatement ps=con.prepareStatement("select * from customer_details");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				if(rs.getLong(1)==details.getFromAccountNo()) {
					balance3=rs.getInt(10);
				}
			}
			balance3=balance3-details.getAmountTransferred();
			PreparedStatement ps1=con.prepareStatement("update customer_details set balance=? where account_no=?");
			ps1.setDouble(1,balance3);
			ps1.setLong(2,details.getFromAccountNo());
			ps1.executeUpdate();
			//checking for toAccountNo and crediting money
			ResultSet rs1=ps.executeQuery();
			while(rs1.next()) {
				if(rs1.getLong(1)==details.getToAccountNo()) {
					balance4=rs1.getInt(10);
				}
			}
			balance4=balance4+details.getAmountTransferred();
			PreparedStatement ps2=con.prepareStatement("update customer_details set balance=? where account_no=?");
			ps2.setDouble(1,balance4);
			ps2.setLong(2,details.getToAccountNo());
			ps2.executeUpdate();
			
			String sqlQuery="insert into transaction_details values(transaction_id,?,?,?)";
			PreparedStatement ps3=con.prepareStatement(sqlQuery);
			ps3.setLong(1,details.getFromAccountNo());
			ps3.setLong(2,details.getToAccountNo());
			ps3.setDouble(3,details.getAmountTransferred());
			int i=ps3.executeUpdate();
			
		}catch(Exception e) {
			
		}
		return i;
	}

}
