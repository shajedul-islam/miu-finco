package factory;

import java.sql.Date;

import domain.impl.Account;
import domain.impl.CCAccount;
import domain.impl.ConcreteCCard;

public class CCAccountFactory extends AbstractAccountFactory {

    public CCAccount CreateAccount(String cc_number, Date exp_date, String nm, String ste, String ct, String sta, String zp, String em) {
        return new ConcreteCCard(cc_number, exp_date, nm, ste, ct, sta, zp, em);
    }
}
