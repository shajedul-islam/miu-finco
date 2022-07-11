package service.impl;

import repository.ICCAccountRepository;
import service.ICCAccountService;

public class CCAccountService implements ICCAccountService {
    private ICCAccountRepository ccAccountRepository;

    public void setCcAccountRepository(ICCAccountRepository ccAccountRepository) {
        System.out.println("--- CCAccountService.setCcAccountRepository()");
        this.ccAccountRepository = ccAccountRepository;
    }

    public ICCAccountRepository getCcAccountRepository() {
        return ccAccountRepository;
    }

}
