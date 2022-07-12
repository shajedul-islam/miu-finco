package service.impl;

import domain.impl.Account;
import repository.IAccountRepository;
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
}
