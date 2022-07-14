package repository;

import java.util.List;

import domain.impl.Account;
import domain.impl.Customer;
import domain.impl.Entry;
import ioc.IComponent;

public interface DataAccess extends IComponent {

    public void saveAccount(Account account);

    public void updateAccount(Account account);

    public Account getAccountByAccountNumber(String accNumber);

    public void saveCustomer(Customer customer);

    public void saveEntry(Entry entry);

    public List<Account> getAccountByCustomerId(int custId);

    public Customer getCustomerById(int custId);

    public List<Customer> getallCustomer();

    public List<Account> getallAccount();
}
