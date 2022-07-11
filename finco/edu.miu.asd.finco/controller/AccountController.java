package controller;

import component.IController;
import component.IService;
import service.IAccountService;

public class AccountController implements IController {
    private IAccountService accountService;

    public void setAccountService(IAccountService accountService) {
        System.out.println("--- AccountController.setAccountService()");
        this.accountService = accountService;
    }

    public IAccountService getAccountService() {
        return accountService;
    }

}
