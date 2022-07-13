package project.bank.edu.miu.asd.bank.domain.impl;

import domain.impl.Account;
import project.bank.edu.miu.asd.bank.domain.BankAccount;

public class Checkings extends BankAccount {
    private double interest_rate = 1.0;
    public double getInterestRate()
    {
    	return interest_rate;
    }
    public void setInterestRate(double interestRate)
    {
      this.interest_rate = interestRate;
    }
	public Checkings(String accnr) {
		super(accnr);
	}
}
