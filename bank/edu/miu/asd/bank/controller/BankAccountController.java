package project.bank.edu.miu.asd.bank.controller;

import domain.impl.Entry;
import ioc.IComponent;
import project.bank.edu.miu.asd.bank.domain.BankAccount;
import project.bank.edu.miu.asd.bank.service.IBankAccountService;
import project.bank.edu.miu.asd.bank.service.IBankCustomerService;

public class BankAccountController implements IComponent {
    private IBankAccountService accountService;
    private IBankCustomerService customerService;

    public void setAccountService(IBankAccountService accountService) {
        System.out.println("--- AccountController.setAccountService()");
        this.accountService = accountService;
    }

    public IBankAccountService getAccountService() {
        return accountService;
    }
    
    public IBankCustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(IBankCustomerService customerService) {
		this.customerService = customerService;
	}

	public void CreateAccount(BankAccount account)
    {

    	accountService.createAccount(account);
    }
	
	public void addEntry(String accNumber, Entry entry)
	{
		accountService.addEntry(accNumber, entry);
	}

}
