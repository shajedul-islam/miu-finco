package project.bank.edu.miu.asd.bank.controller;

import domain.impl.Entry;
import domain.impl.TransactionType;
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

    public void addEntry(String accNumber, double transactionAmount, TransactionType transactionType) {
        Entry entry = new Entry(transactionAmount,transactionType);
        accountService.addEntry(accNumber, entry);
    }

    public void addIntertestToAllAccounts()
    {
        accountService.addIntertestToAllAccounts();
    }


}
