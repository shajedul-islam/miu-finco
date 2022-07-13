package service.impl;

import java.util.List;

import domain.impl.Account;
import domain.impl.Customer;
import domain.impl.Entry;
import domain.impl.TransactionType;
import repository.IAccountRepository;
import repository.ICustomerRepository;
import repository.IEntryRepository;
import repository.impl.AccountRepository;
import repository.impl.EntryRepository;
import service.IAccountService;

public class AccountService implements IAccountService {
    private IAccountRepository accountRepository;
    private IEntryRepository entryRepository;
    private ICustomerRepository customerRepository;

    public IEntryRepository getEntryRepository() {
        return entryRepository;
    }

    public void setEntryRepository(IEntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public ICustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public void setCustomerRepository(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void setAccountRepository(IAccountRepository accountRepository) {
        System.out.println("--- AccountService.setAccountRepository()");
        this.accountRepository = accountRepository;
    }

    public IAccountRepository getAccountRepository() {
        return accountRepository;
    }

    @Override
    public void createAccount(Account account) {
        accountRepository.createAccount(account);
    }

    @Override
    public void createAccount(List<Account> accounts) {
        for (Account ac : accounts) {
            accountRepository.createAccount(ac);
        }
    }

    @Override
    public void addEntry(String accNumber, Entry entry) {
        Account account = accountRepository.getAccountByAccountNumber(accNumber);
        Customer customer = customerRepository.getCustomerById(account.getCustomerId());
        account.addObserver(customer);

        if (entry.getTransactionType() == TransactionType.Credit) {
            account.setBalance(account.getBalance() + entry.getAmount());
        } else {
            account.setBalance(account.getBalance() - entry.getAmount());
        }

        entry.setAccountId(account.getId());
        entryRepository.addEntry(entry);
        accountRepository.updateAccount(account);

        if (entry.getTransactionType() == TransactionType.Credit && entry.getAmount() > 400) {
            account.alert("Alert: Amount >400 Deposited!");
        } else if (entry.getTransactionType() == TransactionType.Debit && account.getBalance() < 0) {
            {
                account.alert("Alert: Balance < 0!");
            }
        }
    }
}
