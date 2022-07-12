package repository;

import domain.impl.Entry;
import ioc.IComponent;

public interface IEntryRepository extends IComponent{

	 public void addEntry(Entry entry);
}
