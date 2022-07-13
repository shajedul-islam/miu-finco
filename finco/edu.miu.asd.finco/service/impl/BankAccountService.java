package project.bank.edu.miu.asd.bank.service.impl;

import domain.impl.Account;
import domain.impl.Entry;
import project.bank.edu.miu.asd.bank.domain.BankAccount;
import project.bank.edu.miu.asd.bank.repository.IBankAccountRepository;
import project.bank.edu.miu.asd.bank.repository.impl.BankAccountRepository;
import project.bank.edu.miu.asd.bank.service.IBankAccountService;
import repository.IAccountRepository;
import repository.IEntryRepository;
import repository.impl.AccountRepository;
import repository.impl.EntryRepository;
import service.IAccountService;

import java.util.List;

public class BankAccountService implements IBankAccountService {
    private IBankAccountRepository accountRepository;

    public void setAccountRepository(IBankAccountRepository accountRepository) {
        System.out.println("--- AccountService.setAccountRepository()");
        this.accountRepository = accountRepository;
    }

    public IBankAccountRepository getAccountRepository() {
        return accountRepository;
    }

	@Override
	public void createAccount(BankAccount account) {
		accountRepository.createAccount(account);
	}

	@Override
	public void createAccount(List<BankAccount> accounts) {
	
		accountRepository = new BankAccountRepository();
		for(BankAccount ac : accounts)
		{
		  accountRepository.createAccount(ac);
		}
	}

	@Override
	public void addEntry(String accNumber, Entry entry) {
		
		IEntryRepository entryRepository = new EntryRepository(); 
		Account account = accountRepository.getAccountByAccountNumber(accNumber);
		entry.setAccountId(account.getId());
		entryRepository.addEntry(entry);
	}
}
