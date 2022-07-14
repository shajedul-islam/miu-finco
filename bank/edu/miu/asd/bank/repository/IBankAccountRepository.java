package project.bank.edu.miu.asd.bank.repository;

import domain.impl.Account;
import ioc.IComponent;
import project.bank.edu.miu.asd.bank.domain.BankAccount;

import java.util.List;

public interface IBankAccountRepository extends IComponent {
    
	public void test(String s);
    public int save(BankAccount account);
    public BankAccount getAccountByAccountNumber(String accNumber);
    public void updateAccount(BankAccount account);
    public List<BankAccount> getallAccounts();

}
