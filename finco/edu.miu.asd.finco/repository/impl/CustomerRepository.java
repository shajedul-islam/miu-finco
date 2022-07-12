package repository.impl;

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
	public void CreateCustomer(Customer customer) {
		
		dataaccess.SaveCustomer(customer);
	}

}
