package factory;

import domain.impl.Account;
import domain.impl.CCAccount;
import domain.impl.ConcreteAccount;
import domain.impl.ConcreteCCard;

import java.sql.Date;

public class CCAccountFactory {
    public static CCAccount CreateAccount(String cc_number, Date exp_date){
        return new ConcreteCCard(cc_number,exp_date);
    }
}
