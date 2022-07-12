package service;

import domain.impl.Customer;
import ioc.IComponent;

public interface ICustomerService extends IComponent{
	public void CreateCustomer(Customer customer);
}
