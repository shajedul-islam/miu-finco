package service.impl;

import domain.impl.Entry;
import repository.IEntryRepository;
import repository.impl.EntryRepository;
import service.IEntryService;

public class EntryService implements IEntryService {

    private IEntryRepository entryRepository;

    public IEntryRepository getEntryRepository() {
        return entryRepository;
    }

    public void setEntryRepository(IEntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public EntryService() {
    }

    @Override
    public void addEntry(Entry entry) {
        entryRepository.addEntry(entry);
    }

}
