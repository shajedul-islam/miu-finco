package domain.impl;

import domain.ICustomer;

public abstract class Customer implements ICustomer {
	
    public String name;
	
	public String street;
	
	public String city;
	
	public String state;
	
	public String zip;
	
	public String email;
	
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
	
	public Customer(String nm, String ste, String ct, String sta, String zp, String em)
	{
		this.name = nm;
		this.street = ste;
		this.city = ct;
		this.state = sta;
		this.zip = zp;
		this.email = em;
	}
}
