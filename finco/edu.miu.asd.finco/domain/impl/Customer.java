package domain.impl;

import java.util.ArrayList;
import java.util.List;

import domain.ICustomer;

public abstract class Customer implements ICustomer {
	
    protected String name;
	
    protected String street;
	
    protected String city;
	
    protected String state;
	
    protected String zip;
	
    protected String email;
	
    protected List<Account> accounts;
	
    protected List<CCAccount> ccaccounts;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getStreet()
	{
		return street;
	}
	
	public void setStreet(String street)
	{
		this.street = street;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public String getState()
	{
		return state;
	}
	
	public void setState(String state)
	{
		this.state = state;
	}
	
	public String getZip()
	{
		return zip;
	}
	
	public void setZip(String zip)
	{
		this.zip = zip;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public void AddAccount(Account acc)
	{
	  accounts.add(acc);
	}
	
	public void AddAccount(CCAccount ccacc)
	{
		ccaccounts.add(ccacc);
	}
	
	public Customer(String nm, String ste, String ct, String sta, String zp, String em)
	{
		this.name = nm;
		this.street = ste;
		this.city = ct;
		this.state = sta;
		this.zip = zp;
		this.email = em;
		this.accounts = new ArrayList<Account>();
		this.ccaccounts = new ArrayList<CCAccount>();
	}
}
