package controller;

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

}
