package repository.impl;

import java.util.List;

import domain.impl.Customer;
import repository.DataAccess;
import repository.ICustomerRepository;

public class CustomerRepository implements ICustomerRepository{

	public DataAccess dataaccess;
	public CustomerRepository()
	{
	  dataaccess = new DataAccessFacade();
	}
	
	@Override
	public void createCustomer(Customer customer) {
		
		dataaccess.SaveCustomer(customer);
	}

	@Override
	public List<Customer> getallCustomer() {
		
		return dataaccess.getallCustomer();
	}
	
}
