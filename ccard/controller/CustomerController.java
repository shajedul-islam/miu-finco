package project.ccard.controller;

import domain.impl.CCAccount;
import domain.impl.Customer;
import ioc.IComponent;
import project.ccard.domain.Person;
import project.ccard.factory.CCardFactory;
import project.ccard.repository.ICCDataAccess;
import project.ccard.repository.CCDataAccessFacade;

import java.util.List;

public class CustomerController implements IComponent {
    public ICCDataAccess dataaccess = new CCDataAccessFacade();

    public CustomerController() {
    }
    public void createCustomer(Customer customer) {
        dataaccess.saveCustomer(customer);
    }
    public void createCustomer(String cardType, String ccNumber, String expireDate, String name, String street, String city, String state, String zip, String email)
    {
        Customer customer = new Person(name, street, city, state, zip, email);
        CCAccount account = CCardFactory.CreateCard(ccNumber,expireDate,cardType);
        customer.AddAccount(account);
        createCustomer(customer);
        account.setCustomerId(customer.getId());
        dataaccess.saveCCAccount(account);
    }
    public List<Customer> getallCustomers() {
        return  dataaccess.getallCustomer();
    }

}
