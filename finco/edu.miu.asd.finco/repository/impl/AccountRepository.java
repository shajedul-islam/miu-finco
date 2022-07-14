package repository.impl;

import domain.impl.Account;
import repository.DataAccess;
import repository.IAccountRepository;

public class AccountRepository implements IAccountRepository {

    private DataAccess dataaccess;

    public DataAccess getDataaccess() {
        return dataaccess;
    }

    public void setDataaccess(DataAccess dataaccess) {
        this.dataaccess = dataaccess;
    }

    public AccountRepository() {
    }

    public void test(String s) {
        System.out.println("--- AccountRepository test: " + s);
    }

    @Override
    public void saveAccount(Account account) {
        try {
            dataaccess.saveAccount(account);
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    @Override
    public void updateAccount(Account account) {
        dataaccess.updateAccount(account);
    }

    @Override
    public Account getAccountByAccountNumber(String accNumber) {

        return dataaccess.getAccountByAccountNumber(accNumber);
    }


}
