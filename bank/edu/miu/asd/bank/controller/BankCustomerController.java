package project.bank.edu.miu.asd.bank.controller;

import domain.impl.Account;
import domain.impl.ConcretePerson;
import domain.impl.Customer;
import factory.AccountFWfactory;
import ioc.IComponent;
import project.bank.edu.miu.asd.bank.domain.BankAccount;
import project.bank.edu.miu.asd.bank.domain.BankCustomer;
import project.bank.edu.miu.asd.bank.domain.impl.Person;
import project.bank.edu.miu.asd.bank.factory.AccountFactory;
import project.bank.edu.miu.asd.bank.factory.AccountFor;
import project.bank.edu.miu.asd.bank.factory.AccountType;
import project.bank.edu.miu.asd.bank.repository.BankDataAccess;
import project.bank.edu.miu.asd.bank.repository.impl.DataAccessFacadeBank;


import java.util.List;

public class BankCustomerController implements IComponent{

	public BankDataAccess dataaccess= new DataAccessFacadeBank();
	public BankDataAccess getDataaccess() {
		return dataaccess;
	}
	public void setDataaccess(BankDataAccess dataaccess) {
		this.dataaccess = dataaccess;
	}

	public BankCustomerController()
	{
	}

	public int createCustomer(BankCustomer customer) {
		//return customerService.save(customer);

		dataaccess.SaveCustomer(customer);
		List<BankAccount> accounts = customer.getBankAccounts();
		for(BankAccount ac : accounts)
		{
			ac.setCustomerId(customer.getId());
			return dataaccess.SaveAccount(ac);
		}
		return 0;

	}

	public void createCustomer(AccountType accountType, String accountNumber, AccountFor accountFor, String name, String street, String city, String state, String zip, String email)
	{

		BankCustomer bankCustomer = new Person(name, street, city, state, zip, email, null);
		BankAccount bankAccount = AccountFactory.CreateAccount(accountType, accountNumber, accountFor);
		bankCustomer.addBankAccount(bankAccount);
		//customerService.save(bankCustomer);
		dataaccess.SaveCustomer(bankCustomer);
	}

	public List<BankCustomer> getallCustomer() {
		//return customerService.getallCustomer();
		return dataaccess.getallCustomer();
	}
}
