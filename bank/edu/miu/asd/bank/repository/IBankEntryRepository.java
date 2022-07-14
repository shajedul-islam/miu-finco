package project.bank.edu.miu.asd.bank.repository;

import domain.impl.Entry;
import ioc.IComponent;

public interface IBankEntryRepository extends IComponent {

    public void addEntry(Entry entry);
}
