package repository;

import java.util.List;

import domain.impl.Customer;
import ioc.IComponent;

public interface ICustomerRepository extends IComponent {

    public void saveCustomer(Customer customer);
    public List<Customer> getallCustomer();
    public Customer getCustomerById(Integer id);
}
