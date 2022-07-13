package domain.impl;

import java.io.Serializable;

import domain.IOrganization;

public class ConcreteOrganization extends Customer implements IOrganization, Serializable {
    public ConcreteOrganization(String nm, String ste, String ct, String sta, String zp, String em) {
        super(nm, ste, ct, sta, zp, em);
    }
}
