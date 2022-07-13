package domain.impl;

import domain.IPerson;

import java.io.Serializable;
import java.sql.Date;

public class ConcretePerson extends Customer implements IPerson, Serializable {

    public ConcretePerson(String nm, String ste, String ct, String sta, String zp, String em) {
        super(nm, ste, ct, sta, zp, em);

    }

    public ConcretePerson() {
    }
}
