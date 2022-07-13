package project.bank.edu.miu.asd.bank.service.impl;

import domain.impl.Account;
import domain.impl.Customer;
import project.bank.edu.miu.asd.bank.domain.BankAccount;
import project.bank.edu.miu.asd.bank.domain.BankCustomer;
import project.bank.edu.miu.asd.bank.repository.IBankAccountRepository;
import project.bank.edu.miu.asd.bank.repository.IBankCustomerRepository;
import project.bank.edu.miu.asd.bank.repository.impl.BankAccountRepository;
import project.bank.edu.miu.asd.bank.repository.impl.BankCustomerRepository;
import project.bank.edu.miu.asd.bank.service.IBankCustomerService;
import repository.IAccountRepository;
import repository.ICustomerRepository;
import repository.impl.AccountRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.util.List;

public class BankCustomerService implements IBankCustomerService{

	private IBankCustomerRepository customerRepository;
	private IBankAccountRepository accountRepository;

	public IBankAccountRepository getAccountRepository() {
		return accountRepository;
	}

	public void setAccountRepository(IBankAccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public void setCustomerRepository(IBankCustomerRepository customerRepository) {
        System.out.println("--- CustomerService.setCustomerRepository()");
        this.customerRepository = customerRepository;
    }

    public IBankCustomerRepository getCustomerRepository() {
        return customerRepository;
    }


	@Override
	public void createCustomer(BankCustomer customer) {
		customerRepository = new BankCustomerRepository();
		accountRepository = new BankAccountRepository();

		customerRepository.createCustomer(customer);

		List<BankAccount> accounts = customer.getBankAccounts();

		for(BankAccount ac : accounts)
		{
		  ac.setCustomerId(customer.getId());
		  accountRepository.createAccount(ac);
		}
	}
}
