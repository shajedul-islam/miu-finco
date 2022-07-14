 package project.bank.edu.miu.asd.bank.service.impl;

import project.bank.edu.miu.asd.bank.domain.BankAccount;
import project.bank.edu.miu.asd.bank.domain.BankCustomer;
import project.bank.edu.miu.asd.bank.repository.IBankAccountRepository;
import project.bank.edu.miu.asd.bank.repository.IBankCustomerRepository;
import project.bank.edu.miu.asd.bank.service.IBankCustomerService;

import java.util.List;

public class BankCustomerService implements IBankCustomerService{

	private IBankCustomerRepository customerRepository;
	private IBankAccountRepository accountRepository;

	public IBankCustomerRepository getCustomerRepository() {
		return customerRepository;
	}

	public void setCustomerRepository(IBankCustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public IBankAccountRepository getAccountRepository() {
		return accountRepository;
	}

	public void setAccountRepository(IBankAccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public int save(BankCustomer customer) {

		customerRepository.save(customer);

		List<BankAccount> accounts = customer.getBankAccounts();

		for(BankAccount ac : accounts)
		{
		  ac.setCustomerId(customer.getId());
		  return accountRepository.save(ac);
		}
		return 0;
	}

	@Override
	public List<BankCustomer> getallCustomer() {
		return customerRepository.getallCustomer();
	}



}
