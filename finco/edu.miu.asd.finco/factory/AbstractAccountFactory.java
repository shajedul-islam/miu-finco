package factory;

import domain.impl.Account;

public abstract class AbstractAccountFactory {

    //public abstract Account CreateAccount();

    public static AbstractAccountFactory CreateAccountFactory(AccountType accountType) {
        return accountType == accountType.ACCOUNT ? new AccountFactory() : new CCAccountFactory();
    }
}
