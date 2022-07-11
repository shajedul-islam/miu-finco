package controller;

import ioc.IComponent;
import service.ICCAccountService;

public class CCAccountController implements IComponent {
    private ICCAccountService ccAccountService;

    public void setCcAccountService(ICCAccountService ccAccountService) {
        System.out.println("--- CCAccountController.setCcAccountService()");
        this.ccAccountService = ccAccountService;
    }

    public ICCAccountService getCcAccountService() {
        return ccAccountService;
    }

}
