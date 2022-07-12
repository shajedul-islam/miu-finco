package service;

import java.util.List;

import domain.impl.Account;
import ioc.IComponent;

public interface IAccountService extends IComponent {
	public void CreateAccount(Account account);
	public void CreateAccount(List<Account> accounts);
}
