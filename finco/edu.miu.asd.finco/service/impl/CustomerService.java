package service.impl;

import domain.impl.Customer;
import repository.ICustomerRepository;
import service.ICustomerService;

public class CustomerService implements ICustomerService{

	private ICustomerRepository customerRepository;

    public void setAccountRepository(ICustomerRepository customerRepository) {
        System.out.println("--- CustomerService.setCustomerRepository()");
        this.customerRepository = customerRepository;
    }

    public ICustomerRepository getCustomerRepository() {
        return customerRepository;
    }
    
	@Override
	public void CreateCustomer(Customer customer) {		
		customerRepository.CreateCustomer(customer);
	}

}
