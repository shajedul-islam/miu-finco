package service;

import java.util.List;

import domain.impl.Account;
import ioc.IComponent;

public interface IAccountService extends IComponent {
	public void createAccount(Account account);
	public void createAccount(List<Account> accounts);
}
