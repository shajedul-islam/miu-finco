package repository.impl;

import domain.impl.Account;
import repository.DataAccess;
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
	public void createAccount(Account account) {
		try {
			dataaccess.SaveAccount(account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public Account getAccountByAccountNumber(String accNumber) {
		
		return dataaccess.getAccountByAccountNumber(accNumber);
	}
	
	
}
