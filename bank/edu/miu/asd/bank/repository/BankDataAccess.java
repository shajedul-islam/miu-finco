package project.bank.edu.miu.asd.bank.repository;

import domain.impl.Account;
import domain.impl.Customer;
import domain.impl.Entry;
import ioc.IComponent;
import project.bank.edu.miu.asd.bank.domain.BankAccount;
import project.bank.edu.miu.asd.bank.domain.BankCustomer;

import java.sql.SQLException;
import java.util.List;

public interface BankDataAccess extends IComponent {

	public int SaveAccount(BankAccount account);
	
	public BankAccount getAccountByAccountNumber(String accNumber);
	
	public void SaveCustomer(BankCustomer customer);
	
	public void saveEntry(Entry entry);

	public List<BankCustomer> getallCustomer();

	public List<BankAccount> getAccountByCustomerId(int custId);

	public BankCustomer getCustomerById(int custId);

	public void updateAccount(BankAccount account);

	public List<BankAccount> getallAccounts();

}
