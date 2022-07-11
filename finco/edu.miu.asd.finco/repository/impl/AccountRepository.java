package repository.impl;

import component.IComponent;
import repository.IAccountRepository;

public class AccountRepository implements IAccountRepository {
    public void test(String s) {
        System.out.println("--- AccountRepository test: " + s);
    }
}
