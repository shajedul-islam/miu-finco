package project.bank.edu.miu.asd.bank.domain.impl;

import project.bank.edu.miu.asd.bank.domain.BankAccount;

public class Savings extends BankAccount {
    /*private static final double interest_rate = 1.25;*/
    public Savings() {
        this.account_type = "Savings";
        interest_rate = 1.25;
    }

	public Savings(String accnr, String personOrCompany) {
        super(accnr);
        this.account_type = "Savings";
        interest_rate = 1.25;
        this.setCompany_or_person(personOrCompany);
	}
}
