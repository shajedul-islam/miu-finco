package domain.impl;

import domain.IPerson;

import java.sql.Date;

public class ConcretePerson extends Customer implements IPerson {

	public Date birthdate;
	
	public Date getBirthDate()
	{
		return birthdate;
	}

	public ConcretePerson(String nm, String ste, String ct, String sta, String zp, String em, Date db) {
		super(nm, ste, ct, sta, zp, em);
		
		this.birthdate = db;
	}
}
