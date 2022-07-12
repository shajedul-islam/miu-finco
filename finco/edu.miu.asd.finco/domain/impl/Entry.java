package domain.impl;

import domain.IEntry;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Entry implements IEntry {
	
	private int id; 
	
	private int accountId; 
	
	private String date ;
	
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
	
	public String getDate()
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
	
	public Entry(double amount, TransactionType transactionType)
	{
		this.date = LocalDateTime.now()
			       .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.amount = amount;
		this.transactionType = transactionType;
	}
}
