package project.ccard.controller;

import domain.impl.*;
import ioc.IComponent;
import project.ccard.repository.ICCDataAccess;
import project.ccard.repository.CCDataAccessFacade;

public class CCAccountController implements IComponent
{
    public ICCDataAccess dataaccess = new CCDataAccessFacade();

    public CCAccountController()
    {
    }

    public void addEntry(String accNumber, double transactionAmount, TransactionType transactionType) {
        Entry entry = new Entry(transactionAmount,transactionType);

        CCAccount account = dataaccess.getCCAccountByAccountNumber(accNumber);
        Customer customer = dataaccess.getCustomerById(account.getCustomerId());
        //account.addObserver(customer);
        if (entry.getTransactionType() == TransactionType.Credit) {
            account.setBalance(account.getBalance() + entry.getAmount());
        } else {
            account.setBalance(account.getBalance() - entry.getAmount());
        }

        entry.setAccountId(account.getId());
        dataaccess.saveEntry(entry);
        dataaccess.updateCCAccount(account);

        if (entry.getTransactionType() == TransactionType.Credit && entry.getAmount() > 400) {
            //account.alert("Alert: Amount >400 Deposited!");
        }
        else if (entry.getTransactionType() == TransactionType.Debit && account.getBalance() < 0) {
        {
            //account.alert("Alert: Balance < 0!");
        }
        }
    }

}
