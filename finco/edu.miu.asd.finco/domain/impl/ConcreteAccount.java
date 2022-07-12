package domain.impl;

import java.io.Serializable;
import java.sql.Date;

public class ConcreteAccount extends Account {

    private double interest_rate = 0;
    
    public double getInterestRate()
    {
    	return interest_rate;
    }
    
    public void setInterestRate(double interestRate)
    {
      this.interest_rate = interestRate;
    }
    
	public ConcreteAccount(String accnr) {
		super(accnr);
	}
}
