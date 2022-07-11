package project.bank.edu.miu.asd.bank;

import ioc.IOCContainer;

public class Bank {
    public static void main(String[] args) {
        IOCContainer.buildApplicationContext(Bank.class.getResourceAsStream("bank-dependencies.properties"));
    }
}
