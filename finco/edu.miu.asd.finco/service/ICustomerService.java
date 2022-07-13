package service;

import java.util.List;

import domain.impl.Customer;
import ioc.IComponent;

public interface ICustomerService extends IComponent {

    public void createCustomer(Customer customer);

    public List<Customer> getallCustomer();
}
