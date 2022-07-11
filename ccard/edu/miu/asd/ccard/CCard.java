package project.ccard.edu.miu.asd.ccard;

import ioc.IOCContainer;

public class CCard {
    public static void main(String[] args) {
        IOCContainer.buildApplicationContext(CCard.class.getResourceAsStream("bank-dependencies.properties"));
    }
}
