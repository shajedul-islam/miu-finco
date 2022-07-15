package domain.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import domain.IAccount;
import observer.IObservable;
import observer.IObserver;

public abstract class Account implements IAccount {
    private List<IObserver> observers = new ArrayList<>();
    private List<Entry> entries = new ArrayList<>();

    private static final long serialVersionUID = -2226197306790714013L;
    protected int id;
    protected int customerId;
    protected String accnr;
    protected double balance;

    protected double interest_rate;
    public Account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getAccNumber() {
        return accnr;
    }

    public double getBalance() {
        return balance;
    }

    public double getInterest_rate() {
        return interest_rate;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account(String accnr) {
        this.accnr = accnr;
        this.balance = 0;
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
