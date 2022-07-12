package controller;

import domain.impl.Customer;
import ioc.IComponent;
import service.IAccountService;
import service.ICustomerService;
import service.impl.AccountService;
import service.impl.CustomerService;

public class CustomerController implements IComponent{

	private ICustomerService customerService;
	private IAccountService accountService;
	
	public  CustomerController()
	{
		customerService = new CustomerService();
		accountService = new AccountService();
	}
	
	public void createCustomer(Customer customer)
    {
		customerService.CreateCustomer(customer);
    }
}
