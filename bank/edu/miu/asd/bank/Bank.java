package project.bank.edu.miu.asd.bank;

import ioc.IOCContainer;
import project.bank.edu.miu.asd.bank.controller.BankAccountController;
import project.bank.edu.miu.asd.bank.domain.BankAccount;
import project.bank.edu.miu.asd.bank.domain.impl.Checkings;

public class Bank {
    public static void main(String[] args) {
        IOCContainer.buildApplicationContext(Bank.class.getResourceAsStream("bank-dependencies.properties"));

        BankAccountController bankAccountController = (BankAccountController) IOCContainer.componentMap.get("bankAccountController");

        BankAccount bankAccount = new Checkings("123ABC");
        bankAccountController.CreateAccount(bankAccount);

        System.out.println();
    }
}
