package domain.impl;

import java.sql.Date;

public class ConcreteCCard extends CCAccount {

    public ConcreteCCard(String cc_number, Date exp_date) {
        super(cc_number, exp_date);
    }

}
