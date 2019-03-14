package com.cg.bank.BankApplications.service;

import com.cg.bank.BankApplications.bean.DetailsDTO;
import com.cg.bank.BankApplications.dao.RegistrationDao;
import com.cg.bank.BankApplications.dao.RegistrationDaoImpl;

public class RegistrationServiceImpl implements RegistrationService{
	RegistrationDao registrationDao=new RegistrationDaoImpl();

	public DetailsDTO register(DetailsDTO details) {
		return registrationDao.register(details);
	}

	public boolean login(long accountNo, String password) {
		return registrationDao.login(accountNo,password);
	}

}
