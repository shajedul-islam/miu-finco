package service;

import domain.impl.Account;
import ioc.IComponent;

public interface IAccountService extends IComponent {
	public void CreateAccount(Account account);
}
