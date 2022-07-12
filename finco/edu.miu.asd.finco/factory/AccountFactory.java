package factory;

import java.sql.Date;

import domain.impl.Account;
import domain.impl.ConcreteAccount;

public class AccountFactory extends AbstractAccountFactory{

	public Account CreateAccount(String accnr) {
		
	   return new ConcreteAccount(accnr);
	}
	
}
