package controller;

import component.IController;
import component.IService;
import service.ICCAccountService;

public class CCAccountController implements IController {
    private ICCAccountService ccAccountService;

    public void setCcAccountService(ICCAccountService ccAccountService) {
        System.out.println("--- CCAccountController.setCcAccountService()");
        this.ccAccountService = ccAccountService;
    }

    public ICCAccountService getCcAccountService() {
        return ccAccountService;
    }

}
