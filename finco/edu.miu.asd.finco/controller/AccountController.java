package controller;

import domain.impl.*;
import ioc.IComponent;
import service.IAccountService;
import service.ICustomerService;
import service.impl.AccountService;

public class AccountController implements IComponent {
    private IAccountService accountService;
    private ICustomerService customerService;

    public void setAccountService(IAccountService accountService) {
        System.out.println("--- AccountController.setAccountService()");
        this.accountService = accountService;
    }

    public IAccountService getAccountService() {
        return accountService;
    }
    
    public ICustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}

	public void CreateAccount(Account account)
    {
    	accountService.createAccount(account);
    }
	
	public void addEntry(String accNumber, Entry entry)
	{
		accountService = new AccountService();
		accountService.addEntry(accNumber, entry);
	}

}
