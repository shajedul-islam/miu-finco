package project.bank.edu.miu.asd.bank.domain;

import domain.impl.Account;

public abstract class BankAccount extends Account {
    public BankAccount(String accnr) {
        super(accnr);
    }

    protected double interest_rate;
    protected String account_type;
    public String getAccount_type()
    {
        return account_type;
    }

    protected String company_or_person;
    public String getCompany_or_person()
    {
        return company_or_person;
    }
}
