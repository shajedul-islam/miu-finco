package controller;

import java.util.List;

import domain.impl.Customer;
import ioc.IComponent;
import service.IAccountService;
import service.ICustomerService;
import service.impl.AccountService;
import service.impl.CustomerService;

public class CustomerController implements IComponent {

    private ICustomerService customerService;

    public CustomerController() {
    }

    public void createCustomer(Customer customer) {
        customerService.createCustomer(customer);
    }

    public List<Customer> getallCustomer() {
        return customerService.getallCustomer();
    }

    public ICustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }
}
