package repository;

import domain.impl.Account;
import ioc.IComponent;

public interface IAccountRepository extends IComponent {

    public void test(String s);

    public void save(Account account);

    public void update(Account account);

    public Account getAccountByAccountNumber(String accNumber);
}
