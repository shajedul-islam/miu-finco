package factory;

import java.sql.Date;

import domain.impl.Account;
import domain.impl.ConcreteAccount;

public class AccountFactory extends AbstractAccountFactory{

	public Account CreateAccount(String accnr, String nm, String ste, String ct, String sta, String zp, String em, int noofemp) {
		
	   return new ConcreteAccount(accnr, nm, ste, ct, sta, zp, em, noofemp);
	}
	
	public Account CreateAccount(String accnr, String nm, String ste, String ct, String sta, String zp, String em, Date db) {
		
	   return new ConcreteAccount(accnr, nm, ste, ct, sta, zp, em, db);
	}

}
