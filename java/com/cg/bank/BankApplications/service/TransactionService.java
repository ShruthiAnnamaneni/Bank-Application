package com.cg.bank.BankApplications.service;

import com.cg.bank.BankApplications.bean.DetailsDTO;

public interface TransactionService {
	public double withdraw(long accountNo,int withdrawAmount);
	public double deposit(long accountNo,int depositAmount);
	public double balance(long accountNo);
	public int transfer(DetailsDTO details);
	
}
