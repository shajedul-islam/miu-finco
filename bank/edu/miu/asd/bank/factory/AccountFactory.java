package project.bank.edu.miu.asd.bank.factory;

import domain.impl.Account;
import domain.impl.ConcreteAccount;
import project.bank.edu.miu.asd.bank.domain.BankAccount;
import project.bank.edu.miu.asd.bank.domain.impl.Checkings;
import project.bank.edu.miu.asd.bank.domain.impl.Savings;

public class AccountFactory {

	public static BankAccount CreateAccount(AccountType accType, String accNumber, String personOrCompany, int customerId) {

		BankAccount acc ;
		if(accType.equals(AccountType.SAVINGS)) {
			acc =  new Savings(accNumber, personOrCompany, customerId);
		}
		else {
			acc =  new Checkings(accNumber, personOrCompany, customerId);
		}

		return  acc;
	}
}
