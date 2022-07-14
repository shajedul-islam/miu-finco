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
import project.bank.edu.miu.asd.bank.service.IBankCustomerService;
import service.ICustomerService;
import service.impl.CustomerService;

import java.util.List;

public class BankCustomerController implements IComponent{

	private IBankCustomerService customerService;

	public IBankCustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(IBankCustomerService customerService) {
		this.customerService = customerService;
	}

	public BankCustomerController()
	{
	}

	public int createCustomer(BankCustomer customer) {
		return customerService.createCustomer(customer);
	}

	public void createCustomer(AccountType accountType, String accountNumber, AccountFor accountFor, String name, String street, String city, String state, String zip, String email)
	{
		/*BankCustomer customer = new Person(name, street, city, state, zip, email, null);
		int customerId = customerService.createCustomer(customer);

		BankAccount account = AccountFactory.CreateAccount(accountType, accountNumber, accountFor, customerId);
		customer.AddAccount(account);*/

		BankCustomer bankCustomer = new Person(name, street, city, state, zip, email, null);
		BankAccount bankAccount = AccountFactory.CreateAccount(accountType, accountNumber, accountFor);
		bankCustomer.addBankAccount(bankAccount);
		customerService.createCustomer(bankCustomer);
	}

	public List<BankCustomer> getallCustomer() {
		return customerService.getallCustomer();
	}
}
