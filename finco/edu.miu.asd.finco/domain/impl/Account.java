package domain.impl;

import domain.IAccount;

public abstract class Account implements IAccount  {
	
    protected String accnr;
    
    protected Customer customer;
    
    public String getAccNumber()
    {
    	return accnr;
    }
   
    public Customer getCustomer()
    {
    	return customer;
    }
    
    public void setCustomer(Customer customer)
    {
    	this.customer =  customer;
    }
	
	public Account(String accnr)
	{
		this.accnr = accnr;
		
	}
	
}
