package domain.impl;

import java.sql.Date;

public class ConcreteCCard extends CCAccount {

	public ConcreteCCard(String cc_number, Date exp_date, String nm, String ste, String ct, String sta, String zp, String em) {
		super(cc_number, exp_date);
		super.customer = new ConcretePerson(nm, ste, ct, sta, zp, em, null);
	}
}
