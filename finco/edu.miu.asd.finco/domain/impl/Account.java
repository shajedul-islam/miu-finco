package domain.impl;

import java.io.Serializable;

import domain.IAccount;

public abstract class Account implements IAccount, Serializable   {
	
	private static final long serialVersionUID = -2226197306790714013L;
	
	protected int id;
	
    protected String accnr;
    
    //protected Customer customer;
   
    public int getId()
    {
    	return id;
    }
    
    public void setId(int id)
    {
    	this.id = id;
    }
    
    public String getAccNumber()
    {
    	return accnr;
    }
   
//    public Customer getCustomer()
//    {
//    	return customer;
//    }
//    
//    public void setCustomer(Customer customer)
//    {
//    	this.customer =  customer;
//    }
	
    
	public Account(String accnr)
	{
		this.accnr = accnr;
		
	}
	
}
