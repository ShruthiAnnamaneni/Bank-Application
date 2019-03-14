package com.cg.bank.BankApplications.dao;

import com.cg.bank.BankApplications.bean.DetailsDTO;

public interface RegistrationDao {
	public DetailsDTO register(DetailsDTO details);
	public boolean login(long accountNo,String password);
}
