package repository;

import java.util.List;

import domain.impl.Customer;
import ioc.IComponent;

public interface ICustomerRepository extends IComponent {

    public void createCustomer(Customer customer);

    public List<Customer> getallCustomer();
}
