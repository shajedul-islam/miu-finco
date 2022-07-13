package service.impl;

import java.util.List;

import domain.impl.Account;
import domain.impl.Customer;
import repository.IAccountRepository;
import repository.ICustomerRepository;
import repository.impl.AccountRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

public class CustomerService implements ICustomerService{

	private ICustomerRepository customerRepository;
	private IAccountRepository accountRepository;

    public void setCustomerRepository(ICustomerRepository customerRepository) {
        System.out.println("--- CustomerService.setCustomerRepository()");
        this.customerRepository = customerRepository;
    }

    public ICustomerRepository getCustomerRepository() {
        return customerRepository;
    }
    
	@Override
	public void createCustomer(Customer customer) {	
		
		customerRepository = new CustomerRepository();
		accountRepository = new AccountRepository();
		
		customerRepository.createCustomer(customer);
		
		List<Account> accounts = customer.getAccounts();
		
		for(Account ac : accounts)
		{
			ac.setCustomerId(customer.getId());
			accountRepository.createAccount(ac);
		}
	}

	
	@Override
	public List<Customer> getallCustomer() {
		
		customerRepository = new CustomerRepository();
		return customerRepository.getallCustomer();
	}

	
}
