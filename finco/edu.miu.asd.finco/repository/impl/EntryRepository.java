package repository.impl;

import domain.impl.Entry;
import repository.DataAccess;
import repository.IEntryRepository;

public class EntryRepository implements IEntryRepository {

    private DataAccess dataaccess;

    public DataAccess getDataaccess() {
        return dataaccess;
    }

    public void setDataaccess(DataAccess dataaccess) {
        this.dataaccess = dataaccess;
    }

    public EntryRepository() {
    }

    @Override
    public void addEntry(Entry entry) {

        dataaccess.saveEntry(entry);
    }
}
