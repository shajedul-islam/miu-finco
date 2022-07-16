package project.bank.edu.miu.asd.bank.controller;

import domain.impl.Entry;
import domain.impl.TransactionType;
import ioc.IComponent;
import project.bank.edu.miu.asd.bank.domain.BankAccount;
import project.bank.edu.miu.asd.bank.domain.BankCustomer;
import project.bank.edu.miu.asd.bank.domain.impl.Checkings;
import project.bank.edu.miu.asd.bank.domain.impl.Savings;
import project.bank.edu.miu.asd.bank.repository.BankDataAccess;
import project.bank.edu.miu.asd.bank.repository.impl.DataAccessFacadeBank;


import java.util.List;

public class BankAccountController implements IComponent {
    public BankDataAccess dataaccess = new DataAccessFacadeBank();
	public void CreateAccount(BankAccount account)
    {
        try {
             dataaccess.SaveAccount(account);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void addEntry(String accNumber, double transactionAmount, TransactionType transactionType) {
        Entry entry = new Entry(transactionAmount,transactionType);
        //accountService.addEntry(accNumber, entry);

        BankAccount account = dataaccess.getAccountByAccountNumber(accNumber);
        BankCustomer customer = dataaccess.getCustomerById(account.getCustomerId());
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

    public void addIntertestToAllAccounts()
    {
        //accountService.addIntertestToAllAccounts();

        Savings savings = new Savings();
        Checkings checkings = new Checkings("");
        List<BankAccount> accounts =  dataaccess.getallAccounts();
        double interestRate = 0;
        double totalInterest = 0;
        for (BankAccount bank: accounts) {
            if(bank.getAccount_type() == "Savings") {
                interestRate = savings.getInterest_rate();
            }
            else {
                interestRate = checkings.getInterest_rate();
            }
            totalInterest = (bank.getBalance() * interestRate);
            Entry entry = new Entry(totalInterest, TransactionType.Credit);
            entry.setAccountId(bank.getId());
            bank.setBalance(bank.getBalance() + totalInterest);

            //entryRepository.addEntry(entry);
            dataaccess.saveEntry(entry);

            //accountRepository.updateAccount(bank);
            dataaccess.updateAccount(bank);
        }
    }


}
