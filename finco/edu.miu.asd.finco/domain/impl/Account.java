package domain.impl;

import java.io.Serializable;

import domain.IAccount;

public abstract class Account implements IAccount, Serializable   {
	
	private static final long serialVersionUID = -2226197306790714013L;
	
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
