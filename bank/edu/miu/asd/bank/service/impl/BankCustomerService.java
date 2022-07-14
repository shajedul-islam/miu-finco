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
	public int createCustomer(BankCustomer customer) {

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
