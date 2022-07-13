package factory;

import java.sql.Date;

import domain.impl.Account;
import domain.impl.ConcreteAccount;

public class AccountFactory extends AbstractAccountFactory{

	public Account CreateAccount(String accnr,String at, String cop) {
		
	   return new ConcreteAccount(accnr,at,cop);
	}
	
}
