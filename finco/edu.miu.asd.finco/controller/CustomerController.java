package controller;

import java.util.List;

import domain.impl.Account;
import domain.impl.ConcretePerson;
import domain.impl.Customer;
import factory.AccountFWfactory;
import ioc.IComponent;
import repository.DataAccess;
import repository.impl.DataAccessFacade;

public class CustomerController implements IComponent {

    public DataAccess dataaccess = new DataAccessFacade();

    public void setDataAccess(DataAccess dataaccess) {
        this.dataaccess = dataaccess;
    }
    public DataAccess getDataAccess() {
        return dataaccess;
    }

    //private ICustomerService customerService;

    public CustomerController() {
    }

    public void createCustomer(Customer customer) {
        //customerService.save(customer);
        dataaccess.saveCustomer(customer);

        List<Account> accounts = customer.getAccounts();
        for (Account ac : accounts) {
            ac.setCustomerId(customer.getId());
            dataaccess.saveAccount(ac);
        }
    }

    public void createCustomer(String accountNumber, String name, String street, String city, String state, String zip, String email)
    {
        Customer customer = new ConcretePerson(name, street, city, state, zip, email);
        Account account = AccountFWfactory.CreateAccount(accountNumber);
        customer.AddAccount(account);
        createCustomer(customer);
    }

    public List<Customer> getallCustomers() {
        //return customerService.getallCustomers();
        return  dataaccess.getallCustomer();
    }
}
