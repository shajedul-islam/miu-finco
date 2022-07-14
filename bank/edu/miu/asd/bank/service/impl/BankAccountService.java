package project.bank.edu.miu.asd.bank.service.impl;

import domain.impl.Account;
import domain.impl.Entry;
import project.bank.edu.miu.asd.bank.domain.BankAccount;
import project.bank.edu.miu.asd.bank.domain.BankCustomer;
import project.bank.edu.miu.asd.bank.repository.IBankAccountRepository;
import project.bank.edu.miu.asd.bank.repository.IBankCustomerRepository;
import project.bank.edu.miu.asd.bank.service.IBankAccountService;
import repository.IEntryRepository;

import java.util.List;

public class BankAccountService implements IBankAccountService {
    private IBankAccountRepository accountRepository;
	private IBankCustomerRepository customerRepository;
	private IEntryRepository entryRepository;

	public IBankCustomerRepository getCustomerRepository() {
		return customerRepository;
	}

	public void setCustomerRepository(IBankCustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public IEntryRepository getEntryRepository() {
		return entryRepository;
	}

	public void setEntryRepository(IEntryRepository entryRepository) {
		this.entryRepository = entryRepository;
	}

	public void setAccountRepository(IBankAccountRepository accountRepository) {
        System.out.println("--- AccountService.setAccountRepository()");
        this.accountRepository = accountRepository;
    }

    public IBankAccountRepository getAccountRepository() {
        return accountRepository;
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
		
		Account account = accountRepository.getAccountByAccountNumber(accNumber);
		entry.setAccountId(account.getId());
		entryRepository.addEntry(entry);
	}
	@Override
	public List<BankCustomer> getallCustomer() {
		return customerRepository.getallCustomer();
	}
}
