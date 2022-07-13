package project.bank.edu.miu.asd.bank.domain;

import domain.impl.Account;
import domain.impl.CCAccount;
import domain.impl.Customer;

import java.util.List;

public abstract class BankCustomer extends Customer {
    public BankCustomer(String nm, String ste, String ct, String sta, String zp, String em) {
        super(nm, ste, ct, sta, zp, em);
    }

    protected double no_of_employees;
    public double getNo_of_employees()
    {
        return no_of_employees;
    }

    protected List<BankAccount> bankaccounts;
    public List<BankAccount> getBankAccounts()
    {
        return bankaccounts;
    }
}
