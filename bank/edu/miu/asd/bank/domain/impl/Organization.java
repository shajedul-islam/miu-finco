package project.bank.edu.miu.asd.bank.domain.impl;

import domain.IOrganization;
import project.bank.edu.miu.asd.bank.domain.BankCustomer;

import java.io.Serializable;

public class Organization extends BankCustomer implements IOrganization, Serializable  {

	public int no_of_employees;

	public int getNoOfEmployees()
	{
		return no_of_employees;
	}

	public void setNoOfEmployees(int noofemp)
	{
		this.no_of_employees = noofemp;
	}

	public Organization(String nm, String ste, String ct, String sta, String zp, String em, int noofemp) {
		super(nm, ste, ct, sta, zp, em);
		this.no_of_employees = noofemp;
		
	}
}
