package controller;

import java.util.List;

import domain.impl.Account;
import domain.impl.ConcretePerson;
import domain.impl.Customer;
import factory.AccountFWfactory;
import ioc.IComponent;
import service.ICustomerService;

public class CustomerController implements IComponent {

    private ICustomerService customerService;

    public CustomerController() {
    }

    public ICustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }

    public void createCustomer(Customer customer) {
        customerService.save(customer);
    }

    public void createCustomer(String accountNumber, String name, String street, String city, String state, String zip, String email)
    {
        Customer customer = new ConcretePerson(name, street, city, state, zip, email);
        Account account = AccountFWfactory.CreateAccount(accountNumber);
        customer.AddAccount(account);
        createCustomer(customer);
    }

    public List<Customer> getallCustomers() {
        return customerService.getallCustomers();
    }

}
