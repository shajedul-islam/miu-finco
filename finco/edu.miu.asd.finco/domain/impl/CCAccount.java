package domain.impl;

import java.sql.Date;
import domain.IAccount;

public abstract class CCAccount implements IAccount {

	protected String cc_number;
	
	protected Date exp_date;
	
	protected double last_month_balance = 0;
	
	protected Customer customer;
	
	public String getAccnr()
	{
	  return cc_number;
	}
	
	public Date getexpExpiryDate()
	{
	  return exp_date;
	}
	
	public double getLast_Month_Balance()
	{
		return last_month_balance;
	}
	
	public Customer getCustomer()
    {
    	return customer;
    }
    
    public void setCustomer(Customer customer)
    {
    	this.customer =  customer;
    }
	
	public CCAccount(String cc_number, Date exp_date)
	{
		this.cc_number = cc_number;
		this.exp_date = exp_date;
	}
	
	
}
