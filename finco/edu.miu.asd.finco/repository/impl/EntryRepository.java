package repository.impl;

import domain.impl.Entry;
import repository.DataAccess;
import repository.IEntryRepository;

public class EntryRepository implements IEntryRepository {

    public DataAccess dataaccess;

    public EntryRepository() {
        dataaccess = new DataAccessFacade();
    }

    @Override
    public void addEntry(Entry entry) {

        dataaccess.saveEntry(entry);
    }
}
