package project.bank.edu.miu.asd.bank.controller;

import domain.impl.Customer;
import ioc.IComponent;
import service.ICustomerService;
import service.impl.CustomerService;

public class BankCustomerController implements IComponent{

	private ICustomerService customerService;

	public BankCustomerController()
	{
		customerService = new CustomerService();
	}
	
	public void createCustomer(Customer customer)
    {
		customerService.createCustomer(customer);
		
		System.out.println("Ho");
		
    }
}
