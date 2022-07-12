package service.impl;

import java.util.List;

import domain.impl.Account;
import repository.IAccountRepository;
import repository.impl.AccountRepository;
import service.IAccountService;

public class AccountService implements IAccountService {
    private IAccountRepository accountRepository;

    public void setAccountRepository(IAccountRepository accountRepository) {
        System.out.println("--- AccountService.setAccountRepository()");
        this.accountRepository = accountRepository;
    }

    public IAccountRepository getAccountRepository() {
        return accountRepository;
    }

	@Override
	public void CreateAccount(Account account) {
		accountRepository.CreateAccount(account);
	}

	@Override
	public void CreateAccount(List<Account> accounts) {
	
		accountRepository = new AccountRepository();
		for(Account ac : accounts)
		{
		  accountRepository.CreateAccount(ac);
		}
	}
}
