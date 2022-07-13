package service;

import java.util.List;

import domain.impl.Account;
import domain.impl.Entry;
import ioc.IComponent;

public interface IAccountService extends IComponent {
    public void createAccount(Account account);

    public void createAccount(List<Account> accounts);

    public void addEntry(String accNumber, Entry entry);
}
