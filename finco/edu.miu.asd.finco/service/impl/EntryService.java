package service.impl;

import domain.impl.Entry;
import repository.IEntryRepository;
import repository.impl.EntryRepository;
import service.IEntryService;

public class EntryService implements IEntryService{

	private IEntryRepository entryRepository;
	public EntryService()
	{
		entryRepository = new EntryRepository();
	}
	
	@Override
	public void addEntry(Entry entry) {
		entryRepository.addEntry(entry);
	}

}
