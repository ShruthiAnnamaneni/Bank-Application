package com.cg.bank.BankApplications.service;

import com.cg.bank.BankApplications.bean.DetailsDTO;
import com.cg.bank.BankApplications.dao.TransactionDao;
import com.cg.bank.BankApplications.dao.TransactionDaoImpl;

public class TransactionServiceImpl implements TransactionService{
	TransactionDao transactionDao=new TransactionDaoImpl();


	public double withdraw(long accountNo,int withdrawAmount) {
		return transactionDao.withdraw(accountNo,withdrawAmount);
	}

	public double deposit(long accountNo,int depositAmount) {
		return transactionDao.deposit(accountNo,depositAmount);
	}

	public double balance(long accountNo) {
		return transactionDao.balance(accountNo);
	}

	public int transfer(DetailsDTO details) {
		return transactionDao.transfer(details);
	}

}
