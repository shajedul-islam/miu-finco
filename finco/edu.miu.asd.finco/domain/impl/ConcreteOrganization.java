package domain.impl;

import domain.IOrganization;

public class ConcreteOrganization extends Customer implements IOrganization {

	public int no_of_employees;
	
	public int getNoOfEmployees()
	{
		return no_of_employees;
	}
	
	public void setNoOfEmployees(int noofemp)
	{
		this.no_of_employees = noofemp;
	}
	
	public ConcreteOrganization(String nm, String ste, String ct, String sta, String zp, String em, int noofemp) {
		super(nm, ste, ct, sta, zp, em);
		this.no_of_employees = noofemp;
		
	}
}
