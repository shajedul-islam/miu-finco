package factory;

import domain.impl.Account;
import domain.impl.ConcreteAccount;

public class AccountFWfactory {
    public static Account CreateAccount(String accnr){
        return new ConcreteAccount(accnr);
    }
}
