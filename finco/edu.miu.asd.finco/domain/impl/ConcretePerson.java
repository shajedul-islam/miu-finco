package domain.impl;

import domain.IOrganization;
import domain.IPerson;

import java.io.Serializable;
import java.sql.Date;

public class ConcretePerson extends Customer implements IPerson, Serializable {
    private IOrganization organization;

    public IOrganization getOrganization() {
        return organization;
    }

    public void setOrganization(IOrganization organization) {
        this.organization = organization;
    }

    public ConcretePerson(String nm, String ste, String ct, String sta, String zp, String em) {
        super(nm, ste, ct, sta, zp, em);
    }

    public ConcretePerson() {
    }
}
