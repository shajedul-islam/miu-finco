package project.bank.edu.miu.asd.bank.domain.impl;

import domain.IPerson;
import project.bank.edu.miu.asd.bank.domain.BankCustomer;

import java.io.Serializable;
import java.sql.Date;

public class Person extends BankCustomer implements IPerson, Serializable {

	public Date birthdate;

	public Date getBirthDate()
	{
		return birthdate;
	}

	public Person(String nm, String ste, String ct, String sta, String zp, String em, Date db) {
		super(nm, ste, ct, sta, zp, em);
		
		this.birthdate = db;
	}
}
