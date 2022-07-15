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
    public void save(Customer customer) {

        dataaccess.saveCustomer(customer);
    }

    @Override
    public List<Customer> getallCustomer() {

        return dataaccess.getallCustomer();
    }

    @Override
    public Customer getCustomerById(Integer id) {

        return dataaccess.getCustomerById(id);
    }

}
