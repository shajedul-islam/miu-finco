package project.bank.edu.miu.asd.bank.repository.impl;

import domain.impl.Account;
import project.bank.edu.miu.asd.bank.domain.BankAccount;
import project.bank.edu.miu.asd.bank.repository.BankDataAccess;
import project.bank.edu.miu.asd.bank.repository.IBankAccountRepository;
import repository.DataAccess;
import repository.IAccountRepository;
import repository.impl.DataAccessFacade;

public class BankAccountRepository implements IBankAccountRepository {

	public BankDataAccess dataaccess;

	public BankDataAccess getDataaccess() {
		return dataaccess;
	}

	public void setDataaccess(BankDataAccess dataaccess) {
		this.dataaccess = dataaccess;
	}

	public BankAccountRepository()
	{

	}
    
    public void test(String s) {
        System.out.println("--- AccountRepository test: " + s);
    }

	@Override
	public void createAccount(BankAccount account) {
		try {
			dataaccess.SaveAccount(account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public BankAccount getAccountByAccountNumber(String accNumber) {
		
		return dataaccess.getAccountByAccountNumber(accNumber);
	}
	
	
}
