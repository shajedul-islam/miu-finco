package project.bank.edu.miu.asd.bank.service.impl;

import domain.impl.Account;
import domain.impl.Customer;
import domain.impl.Entry;
import domain.impl.TransactionType;
import project.bank.edu.miu.asd.bank.domain.BankAccount;
import project.bank.edu.miu.asd.bank.domain.BankCustomer;
import project.bank.edu.miu.asd.bank.domain.impl.Checkings;
import project.bank.edu.miu.asd.bank.domain.impl.Savings;
import project.bank.edu.miu.asd.bank.repository.IBankAccountRepository;
import project.bank.edu.miu.asd.bank.repository.IBankCustomerRepository;
import project.bank.edu.miu.asd.bank.repository.IBankEntryRepository;
import project.bank.edu.miu.asd.bank.service.IBankAccountService;
import repository.IEntryRepository;

import java.util.List;

public class BankAccountService implements IBankAccountService {
    private IBankAccountRepository accountRepository;
	private IBankCustomerRepository customerRepository;
	private IBankEntryRepository entryRepository;

	public IBankAccountRepository getAccountRepository() {
		return accountRepository;
	}

	public void setAccountRepository(IBankAccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public IBankCustomerRepository getCustomerRepository() {
		return customerRepository;
	}

	public void setCustomerRepository(IBankCustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public IBankEntryRepository getEntryRepository() {
		return entryRepository;
	}

	public void setEntryRepository(IBankEntryRepository entryRepository) {
		this.entryRepository = entryRepository;
	}

	@Override
	public void createAccount(BankAccount account) {
		accountRepository.save(account);
	}

	@Override
	public void createAccount(List<BankAccount> accounts) {
	
		for(BankAccount ac : accounts)
		{
		  accountRepository.save(ac);
		}
	}

	@Override
	public void addEntry(String accNumber, Entry entry) {

		BankAccount account = accountRepository.getAccountByAccountNumber(accNumber);
		BankCustomer customer = customerRepository.getCustomerById(account.getCustomerId());
		account.addObserver(customer);

		if (entry.getTransactionType() == TransactionType.Credit) {
			account.setBalance(account.getBalance() + entry.getAmount());
		} else {
			account.setBalance(account.getBalance() - entry.getAmount());
		}

		entry.setAccountId(account.getId());
		entryRepository.addEntry(entry);
		accountRepository.updateAccount(account);

		if (entry.getTransactionType() == TransactionType.Credit && entry.getAmount() > 400) {
			account.alert("Alert: Amount >400 Deposited!");
		} else if (entry.getTransactionType() == TransactionType.Debit && account.getBalance() < 0) {
			{
				account.alert("Alert: Balance < 0!");
			}
		}
	}

	@Override
	public List<BankCustomer> getallCustomer() {
		return customerRepository.getallCustomer();
	}

	public void addIntertestToAllAccounts()
	{
		Savings savings = new Savings();
		Checkings checkings = new Checkings("");
		List<BankAccount> accounts =  accountRepository.getallAccounts();
        double interestRate = 0;
		double totalInterest = 0;
		for (BankAccount bank: accounts) {
			if(bank.getAccount_type() == "Savings") {
				interestRate = savings.getInterest_rate();
			}
			else {
				interestRate = checkings.getInterest_rate();
			}
            totalInterest = (bank.getBalance() * interestRate);
			Entry entry = new Entry(totalInterest, TransactionType.Credit);
			entry.setAccountId(bank.getId());
			bank.setBalance(bank.getBalance() + totalInterest);
			entryRepository.addEntry(entry);
			accountRepository.updateAccount(bank);
		}
	}
}
