package project.ccard.repository;

import domain.impl.CCAccount;
import domain.impl.Customer;
import domain.impl.Entry;
import ioc.IComponent;

import java.util.List;

public interface ICCDataAccess extends IComponent
{
    public void saveCCAccount(CCAccount account);

    public void updateCCAccount(CCAccount account);

    public void saveCustomer(Customer customer);

    public void saveEntry(Entry entry);

    public CCAccount getCCAccountByAccountNumber(String ccAccNumber);

    public List<CCAccount> getCCAccountByCustomerId(int custId);

    public Customer getCustomerById(int custId);

    public List<Customer> getallCustomer();
}
