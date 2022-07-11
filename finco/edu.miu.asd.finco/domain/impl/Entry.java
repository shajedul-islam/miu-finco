package domain.impl;

import domain.IEntry;

import java.sql.Date;

public class Entry implements IEntry {
	
	private Date date ;
	
	private double amount ;
	
	public Date getDate()
	{
	  return date;
	}
	
	public double getAmount()
	{
	  return amount;
	}
	
	public Entry(Date date, double amount)
	{
		this.date = date;
		this.amount = amount;
	}
}
