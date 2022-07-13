package repository;

import java.util.List;

import domain.impl.Customer;

public interface ICustomerRepository {

	public void createCustomer(Customer customer);
	
	public List<Customer> getallCustomer();
}
