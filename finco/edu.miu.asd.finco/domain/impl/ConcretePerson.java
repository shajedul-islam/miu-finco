package domain.impl;

import java.sql.Date;

import domain.IPerson;

public class ConcretePerson extends Customer implements IPerson {

	public Date birthdate;
	
	public Date getBirthDate()
	{
		return birthdate;
	}

	ConcretePerson(String nm, String ste, String ct, String sta, String zp, String em, Date db) {
		super(nm, ste, ct, sta, zp, em);
		
		this.birthdate = db;
	}
}
