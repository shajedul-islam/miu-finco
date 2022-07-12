package repository;

import domain.impl.Account;
import ioc.IComponent;

public interface IAccountRepository extends IComponent {
    public void test(String s);
    
    public void CreateAccount(Account account);
}