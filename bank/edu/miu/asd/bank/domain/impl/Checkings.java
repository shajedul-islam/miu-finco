package project.bank.edu.miu.asd.bank.domain.impl;

import project.bank.edu.miu.asd.bank.domain.BankAccount;

public class Checkings extends BankAccount {
    /*private static final double interest_rate = 1.0;*/

	public Checkings(String accnr, String personOrCompany) {
		super(accnr);
        this.account_type = "Checkins";
        interest_rate = .01;
        this.setCompany_or_person(personOrCompany);
	}

    public Checkings(String accountNo) {
        super(accountNo);
        this.account_type = "Checkins";
        interest_rate = .01;
    }
}
