package domain.impl;

import domain.IEntry;

import java.sql.Date;

public class Entry implements IEntry {
	
	private int id; 
	
	private int accountId; 
	
	private Date date ;
	
	private double amount ;
	
	private TransactionType transactionType;
	
	public int getId()
	{
	  return id;
	}
	
	public void setId(int id)
	{
	  this.id = id;
	}
	
	public int getAccountId()
	{
	  return accountId;
	}
	
	public void setAccountId(int id)
	{
	  this.accountId = id;
	}
	
	public Date getDate()
	{
	  return date;
	}
	
	public double getAmount()
	{
	  return amount;
	}
	
	public TransactionType getTransactionType()
	{
	  return this.transactionType;
	}
	
	public Entry(Date date, double amount, TransactionType transactionType)
	{
		this.date = date;
		this.amount = amount;
		this.transactionType = transactionType;
	}
}
