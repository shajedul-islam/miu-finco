package project.ccard.domain;

import domain.impl.CCAccount;
import java.sql.Date;

public class Bronze extends CCAccount {
    public Bronze(String cc_number,String exp_date, String cardType) {
        super(cc_number,exp_date, cardType);
    }
}
