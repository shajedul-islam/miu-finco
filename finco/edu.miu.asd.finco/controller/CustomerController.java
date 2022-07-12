package controller;

import domain.impl.Customer;
import ioc.IComponent;
import service.IAccountService;
import service.ICustomerService;
import service.impl.AccountService;
import service.impl.CustomerService;

public class CustomerController implements IComponent{

	private ICustomerService customerService;
	
	public  CustomerController()
	{
		customerService = new CustomerService();
	}
	
	public void createCustomer(Customer customer)
    {
		customerService.createCustomer(customer);
		
		System.out.println("Ho");
		
    }
}
