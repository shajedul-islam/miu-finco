package controller;

import domain.impl.*;
import ioc.IComponent;
import service.IAccountService;

public class AccountController implements IComponent {
    private IAccountService accountService;

    public void setAccountService(IAccountService accountService) {
        System.out.println("--- AccountController.setAccountService()");
        this.accountService = accountService;
    }

    public IAccountService getAccountService() {
        return accountService;
    }

    public void createAccount(Account account) {
        accountService.createAccount(account);
    }

    public void addEntry(String accNumber, double transactionAmount, TransactionType transactionType) {
        Entry entry = new Entry(transactionAmount,transactionType);
        accountService.addEntry(accNumber, entry);
    }

}
