package domain.impl;

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
    
	public ConcreteAccount(String accnr, String nm, String ste, String ct, String sta, String zp, String em, int noofemp) {
		super(accnr);
		super.customer = new ConcreteOrganization(nm, ste, ct, sta, zp, em, noofemp);		
	}
	
	public ConcreteAccount(String accnr, String nm, String ste, String ct, String sta, String zp, String em, Date db) {
		super(accnr);
		super.customer = new ConcretePerson(nm, ste, ct, sta, zp, em, db);		
	}
}
