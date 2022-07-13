package project.bank.edu.miu.asd.bank.domain;

import domain.impl.Account;

public abstract class BankAccount extends Account {

    protected static double interest_rate;
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

    public BankAccount(String accnr) {
        super(accnr);
    }

    public BankAccount() {
    }

    public double getInterest_rate() {
        return interest_rate;
    }

    /*public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }*/

    public void setCompany_or_person(String company_or_person) {
        this.company_or_person = company_or_person;
    }
}
