package com.cg.bank.BankApplications;

import java.util.Scanner;

import com.cg.bank.BankApplications.bean.DetailsDTO;
import com.cg.bank.BankApplications.service.RegistrationService;
import com.cg.bank.BankApplications.service.RegistrationServiceImpl;
import com.cg.bank.BankApplications.service.TransactionService;
import com.cg.bank.BankApplications.service.TransactionServiceImpl;

public class Client {
	static RegistrationService registrationService=new RegistrationServiceImpl();
	static TransactionService transactionService=new TransactionServiceImpl();
	static DetailsDTO details=new DetailsDTO();

	public static void main(String args[]) {
		//Client c=new Client();
		//c.settingInput();
		Scanner input=new Scanner(System.in);

		System.out.println("1) Registration  2)Login");
		int i=input.nextInt();
		switch(i) {
		case 1:System.out.println("Enter first name:");
			details.setFirstName(input.next());
			System.out.println("Enter last name: ");
			details.setLastName(input.next());
			System.out.println("Enter email id: ");
			details.setEmailId(input.next());
			System.out.println("enter the password: ");
			details.setPassword(input.next());
			System.out.println("Enter pancard number: ");
			details.setPancardNo(input.next());
			System.out.println("Enter aadhar number: ");
			details.setAadharNo(input.next());
			System.out.println("Enter address: ");
			details.setAddress(input.next());
			System.out.println("Enter mobile number: ");
			details.setMobileNo(input.next());
			System.out.println("Enter balance: ");
			details.setBalance(0);
			//calling register() method with registrationService object
			details=registrationService.register(details);
			System.out.println("Account number of the customer is: "+details.getAccountNo());
		case 2:
			System.out.println("Enter account number");
			long accountNo=input.nextLong();
			details.setAccountNo(accountNo);
			System.out.println("Enter password");
			String password=input.next();
			details.setPassword(password);
			boolean value=registrationService.login(accountNo, password);
			if(value==true) {
			//if(i==1) {
				System.out.println("Login successful");
				do {
				System.out.println("Enter 1) withdraw  2)deposit  3)balance check  4)transfer 5) exit");
				int menu=input.nextInt();
				switch(menu) {
				case 1:
					System.out.println("Enter withdraw amount:");
					int withdrawAmount=input.nextInt();
					System.out.println("Enter account number:");
					long accountNo1=input.nextLong();
					double n=transactionService.withdraw(accountNo,withdrawAmount);
					if(i==n) {
						System.out.println("withdraw completed");
					}
					break;
				case 2:
					System.out.println("Enter deposit amount:");
					int depositAmount=input.nextInt();
					System.out.println("Enter account number:");
					long accountNo2=input.nextLong();
					double a=transactionService.deposit(accountNo,depositAmount);
					if(i==a) {
						System.out.println("deposit completed");
					}
					break;
				case 3:
					System.out.println("Enter account number");
					long accountNo3=input.nextLong();
					double amount=transactionService.balance(accountNo);
					System.out.println("Available balance is: "+amount);				
				break;
				case 4:
					System.out.println("Enter from account number");
					long fromAccount=input.nextLong();
					System.out.println("Enter to account number");
					long toAccount=input.nextLong();
					System.out.println("Enter the amount to be transfered: ");
					double amountTransfer=input.nextDouble() ;
					int s=transactionService.transfer(details);
					if(s==1) {
						System.out.println("Transaction id of transferring amoner from account no"+details.getFromAccountNo()+
								" to "+details.getToAccountNo()+" is "+details.getTransactionId());
					}
					break;
				case 5:
					System.exit(0);
					break;
				}
			   }while(true);
			}
			else {
				System.out.println("Invalid username or password");
			}
			break;
		case 3:
			System.exit(0);
			break;
			
		}
		
	}

}
