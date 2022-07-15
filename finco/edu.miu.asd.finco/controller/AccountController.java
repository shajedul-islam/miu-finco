package controller;

import domain.impl.*;
import ioc.IComponent;
import repository.DataAccess;
import repository.impl.DataAccessFacade;

public class AccountController implements IComponent {

    public DataAccess dataaccess = new DataAccessFacade();
    /*private IAccountService accountService;*/

    /*public void setAccountService(IAccountService accountService) {
        System.out.println("--- AccountController.setAccountService()");
        this.accountService = accountService;
    }

    public IAccountService getAccountService() {
        return accountService;
    }*/

    public void createAccount(Account account) {
        //accountService.save(account);
        dataaccess.saveAccount(account);
    }

    public void addEntry(String accNumber, double transactionAmount, TransactionType transactionType) {
        Entry entry = new Entry(transactionAmount,transactionType);
        //accountService.addEntry(accNumber, entry);

        Account account = dataaccess.getAccountByAccountNumber(accNumber);
        Customer customer = dataaccess.getCustomerById(account.getCustomerId());
        account.addObserver(customer);

        if (entry.getTransactionType() == TransactionType.Credit) {
            account.setBalance(account.getBalance() + entry.getAmount());
        } else {
            account.setBalance(account.getBalance() - entry.getAmount());
        }

        entry.setAccountId(account.getId());
        dataaccess.saveEntry(entry);
        dataaccess.updateAccount(account);

        if (entry.getTransactionType() == TransactionType.Credit && entry.getAmount() > 400) {
            account.alert("Alert: Amount >400 Deposited!");
        } else if (entry.getTransactionType() == TransactionType.Debit && account.getBalance() < 0) {
            {
                account.alert("Alert: Balance < 0!");
            }
        }
    }

}
