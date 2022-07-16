package domain.impl;

import domain.IAccount;
import observer.IObserver;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public abstract class CCAccount implements IAccount {

    private List<Entry> entries = new ArrayList<>();
    private List<IObserver> observers = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    protected int id;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    protected int customerId;
    protected String cc_number;

    public void setExp_date(String exp_date) {
        this.exp_date = exp_date;
    }

    protected String exp_date;

    protected double last_month_balance = 0;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    protected String cardType;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    protected double balance;

    public String getAccnr() {
        return cc_number;
    }

    public String getexpExpiryDate() {
        return exp_date;
    }

    public double getLast_Month_Balance() {
        return last_month_balance;
    }

    public CCAccount(String cc_number, String exp_date, String cardType) {
        this.cc_number = cc_number;
        this.exp_date = exp_date;
        this.cardType = cardType;
    }

    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void alert(String message) {
        for (IObserver observer : observers) {
            observer.update(message);
        }
    }
}
