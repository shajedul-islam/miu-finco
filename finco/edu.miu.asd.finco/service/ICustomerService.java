package service;

import domain.impl.Customer;
import ioc.IComponent;

public interface ICustomerService extends IComponent{
	public void createCustomer(Customer customer);
}
