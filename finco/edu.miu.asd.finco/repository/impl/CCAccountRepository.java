package repository.impl;

import component.IComponent;
import repository.ICCAccountRepository;

public class CCAccountRepository implements ICCAccountRepository {
    public void test(String s) {
        System.out.println("--- CCAccountRepository test: " + s);
    }
}
