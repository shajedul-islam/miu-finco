package repository.impl;

import java.util.List;

import domain.impl.Customer;
import repository.DataAccess;
import repository.ICustomerRepository;

public class CustomerRepository implements ICustomerRepository {

    private DataAccess dataaccess;

    public DataAccess getDataaccess() {
        return dataaccess;
    }

    public void setDataaccess(DataAccess dataaccess) {
        this.dataaccess = dataaccess;
    }

    public CustomerRepository() {
    }

    @Override
    public void createCustomer(Customer customer) {

        dataaccess.SaveCustomer(customer);
    }

    @Override
    public List<Customer> getallCustomer() {

        return dataaccess.getallCustomer();
    }

}
