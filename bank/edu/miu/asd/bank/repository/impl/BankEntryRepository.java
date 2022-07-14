package project.bank.edu.miu.asd.bank.repository.impl;

import domain.impl.Entry;
import project.bank.edu.miu.asd.bank.repository.BankDataAccess;
import project.bank.edu.miu.asd.bank.repository.IBankEntryRepository;
import repository.DataAccess;
import repository.IEntryRepository;

public class BankEntryRepository implements IBankEntryRepository {

    private BankDataAccess dataaccess;

    public BankDataAccess getDataaccess() {
        return dataaccess;
    }

    public void setDataaccess(BankDataAccess dataaccess) {
        this.dataaccess = dataaccess;
    }

    public BankEntryRepository() {
    }

    @Override
    public void addEntry(Entry entry) {

        dataaccess.saveEntry(entry);
    }
}
