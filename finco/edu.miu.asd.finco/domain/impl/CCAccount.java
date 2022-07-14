package domain.impl;

import domain.IAccount;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public abstract class CCAccount implements IAccount {

    private List<Entry> entries = new ArrayList<>();

    protected String cc_number;

    protected Date exp_date;

    protected double last_month_balance = 0;

    public String getAccnr() {
        return cc_number;
    }

    public Date getexpExpiryDate() {
        return exp_date;
    }

    public double getLast_Month_Balance() {
        return last_month_balance;
    }

    public CCAccount(String cc_number, Date exp_date) {
        this.cc_number = cc_number;
        this.exp_date = exp_date;
    }

    @Override
    public void alert(String message) {
        // TODO: implement later
    }
}
