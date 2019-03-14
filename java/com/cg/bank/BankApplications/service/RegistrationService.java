package com.cg.bank.BankApplications.service;

import com.cg.bank.BankApplications.bean.DetailsDTO;

public interface RegistrationService {
	public DetailsDTO register(DetailsDTO details);
	public boolean login(long accountNo,String password);
}
