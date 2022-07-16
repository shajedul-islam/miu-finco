package project.ccard.domain;

import domain.IOrganization;
import domain.IPerson;
import domain.impl.Customer;

public class Person extends Customer implements IPerson {
    private IOrganization organization;

    public IOrganization getOrganization() {
        return organization;
    }

    public void setOrganization(IOrganization organization) {
        this.organization = organization;
    }

    public Person(String nm, String ste, String ct, String sta, String zp, String em) {
        super(nm, ste, ct, sta, zp, em);
    }

    public Person() {
    }
}
