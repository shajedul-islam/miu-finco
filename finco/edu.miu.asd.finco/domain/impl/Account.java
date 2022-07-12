package domain.impl;

import java.io.Serializable;

import domain.IAccount;

public abstract class Account implements IAccount, Serializable   {
	
	private static final long serialVersionUID = -2226197306790714013L;
	
	protected int id;
	
    protected int customerId;
	
    protected String accnr;

    protected double balance;
   
    public int getId()
    {
    	return id;
    }
    
    public void setId(int id)
    {
    	this.id = id;
    }
    
    public int getCustomerId()
    {
      return customerId;
    }
    
    public void setCustomerId(int customerId)
    {
    	this.customerId = customerId;
    }
    
    public String getAccNumber()
    {
    	return accnr;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }
	public Account(String accnr)
	{
		this.accnr = accnr;
        this.balance = 0;
	}
	
}
