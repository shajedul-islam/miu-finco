package project.bank.edu.miu.asd.bank.repository.impl;

import project.bank.edu.miu.asd.bank.domain.BankAccount;
import project.bank.edu.miu.asd.bank.repository.BankDataAccess;
import project.bank.edu.miu.asd.bank.repository.IBankAccountRepository;

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
	public int save(BankAccount account) {
		try {
			return dataaccess.SaveAccount(account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public BankAccount getAccountByAccountNumber(String accNumber) {
		
		return dataaccess.getAccountByAccountNumber(accNumber);
	}

	@Override
	public void updateAccount(BankAccount account) {
		dataaccess.updateAccount(account);
	}


}
