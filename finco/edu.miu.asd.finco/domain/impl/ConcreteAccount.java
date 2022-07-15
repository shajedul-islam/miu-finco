package domain.impl;

import java.io.Serializable;
import java.sql.Date;

public class ConcreteAccount extends Account {

    public ConcreteAccount(String accnr) {
        super(accnr);
        this.interest_rate = 0.01;
    }
}
