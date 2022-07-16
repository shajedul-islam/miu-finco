package project.ccard.domain;
import domain.impl.CCAccount;

import java.sql.Date;

public class Silver extends CCAccount {
    public Silver(String cc_number, String exp_date, String cardType) {
        super(cc_number,exp_date,cardType);
    }
}
