package project.bank.edu.miu.asd.bank.factory;

import project.bank.edu.miu.asd.bank.domain.BankAccount;
import project.bank.edu.miu.asd.bank.domain.impl.Checkings;
import project.bank.edu.miu.asd.bank.domain.impl.Savings;

public class AccountFactory {

	public static BankAccount CreateAccount(AccountType accType, String accNumber, AccountFor accountFor) {

		String personOrCompany = accountFor.equals(AccountFor.COMPANY) ? "Company" : "Personal";
		BankAccount acc ;
		if(accType.equals(AccountType.SAVINGS)) {
			acc =  new Savings(accNumber, personOrCompany);
		}
		else {
			acc =  new Checkings(accNumber, personOrCompany);
		}

		return  acc;
	}
}
