package repository;

import java.util.List;

import domain.impl.Account;
import domain.impl.Customer;
import domain.impl.Entry;

public interface DataAccess {

	public void SaveAccount(Account account);

	public void updateAccount(Account account);

	public Account getAccountByAccountNumber(String accNumber);
	
	public void SaveCustomer(Customer customer);
	
	public void saveEntry(Entry entry);
	
	public List<Account> getAccountByCustomerId(int custId);
	
	public List<Customer> getallCustomer();
}
