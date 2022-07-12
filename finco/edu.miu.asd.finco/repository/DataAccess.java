package repository;

import domain.impl.Account;
import domain.impl.Customer;
import domain.impl.Entry;

public interface DataAccess {

	public void SaveAccount(Account account);
	
	public Account getAccountByAccountNumber(String accNumber);
	
	public void SaveCustomer(Customer customer);
	
	public void saveEntry(Entry entry);
}
