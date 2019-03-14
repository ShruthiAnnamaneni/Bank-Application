package com.cg.bank.BankApplications.dao;

import java.sql.*;

import com.cg.bank.BankApplications.bean.DetailsDTO;

public class RegistrationDaoImpl implements RegistrationDao{
	DetailsDTO details=new DetailsDTO();
	public DetailsDTO register(DetailsDTO details){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SHRUTHI","Annay@27");
			String stmnt="insert into customer_details values(account_no.nextval,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(stmnt);
			ps.setString(1,details.getFirstName());
			ps.setString(2,details.getLastName());
			ps.setString(3,details.getEmailId());
			ps.setString(4,details.getPassword());
			ps.setString(5,details.getPancardNo());
			ps.setString(6,details.getAadharNo());
			ps.setString(7,details.getAddress());
			ps.setString(8,details.getMobileNo());
			ps.setDouble(9,details.getBalance());
			int i=ps.executeUpdate();
			PreparedStatement ps1=con.prepareStatement("select account_number from customer_details where aadhar_no=?");
			ps1.setString(1,details.getAadharNo());
			ResultSet rs=ps1.executeQuery();
			while(rs.next()) {
				details.setAccountNo(rs.getLong(1));
			}
			con.close();
		} catch (Exception e) {
		}
		return details;
	}

	public boolean login(long accountNo, String password) {
		boolean value=false;
		//int i=0;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SHRUTHI","Annay@27");
		PreparedStatement ps=con.prepareStatement("select account_no,password from customer_details where aadharNo=?");
		ps.setString(1,details.getAadharNo());
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			if(rs.getLong(1)==details.getAccountNo()) {
				if(rs.getString(2).equals(details.getPassword())) {
					return value=true;
					//i=1;
				}
			}
			
		}
		}catch(Exception e) {
			
		}
		
		return true;
		//return i;
	}

}
