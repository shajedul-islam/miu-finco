package project.bank.edu.miu.asd.bank.repository;

import ioc.IComponent;
import project.bank.edu.miu.asd.bank.domain.BankAccount;

public interface IBankAccountRepository extends IComponent {
    
	public void test(String s);
    public void createAccount(BankAccount account);
    public BankAccount getAccountByAccountNumber(String accNumber);
}
