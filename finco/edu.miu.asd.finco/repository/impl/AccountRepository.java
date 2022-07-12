package repository.impl;

import domain.impl.Account;
import repository.DataAccessFacade;
import repository.IAccountRepository;

public class AccountRepository implements IAccountRepository {
	
	public DataAccess dataaccess;
	
	public AccountRepository()
	{
		dataaccess = new DataAccessFacade();
	}
    public void test(String s) {
        System.out.println("--- AccountRepository test: " + s);
    }

	@Override
	public void CreateAccount(Account account) {
		dataaccess.SaveAccount(account);
		
	}
}
