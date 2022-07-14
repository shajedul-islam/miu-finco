package project.bank.edu.miu.asd.bank.domain;

import domain.impl.Account;
import domain.impl.Customer;

import java.util.ArrayList;
import java.util.List;

public abstract class BankCustomer extends Customer {
    private List<BankAccount> bankAccounts = new ArrayList<>();

    public BankCustomer(String nm, String ste, String ct, String sta, String zp, String em) {
        super(nm, ste, ct, sta, zp, em);
    }

    protected double no_of_employees;
    public double getNo_of_employees()
    {
        return no_of_employees;
    }

    public void addBankAccount(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
    }
    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
