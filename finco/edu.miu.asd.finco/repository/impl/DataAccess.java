package repository.impl;

import domain.impl.Account;
import domain.impl.Customer;

public interface DataAccess {

	public void SaveAccount(Account account);
	
	public void SaveCustomer(Customer customer);
}
