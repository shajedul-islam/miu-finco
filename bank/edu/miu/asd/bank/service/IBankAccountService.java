package project.bank.edu.miu.asd.bank.service;

import domain.impl.Account;
import domain.impl.Entry;
import ioc.IComponent;
import project.bank.edu.miu.asd.bank.domain.BankAccount;

import java.util.List;

public interface IBankAccountService extends IComponent {
	public void createAccount(BankAccount account);
	public void createAccount(List<BankAccount> accounts);
	public void addEntry(String accNumber, Entry entry);
}
