package project.bank.edu.miu.asd.bank;

import ioc.IOCContainer;
import project.bank.edu.miu.asd.bank.controller.BankAccountController;
import project.bank.edu.miu.asd.bank.domain.BankAccount;
import project.bank.edu.miu.asd.bank.domain.impl.Checkings;
import project.bank.edu.miu.asd.bank.factory.AccountFactory;
import project.bank.edu.miu.asd.bank.factory.AccountType;
import project.bank.edu.miu.asd.bank.gui.BankFrm;

import javax.swing.*;

public class Bank {
    public static void main(String[] args) {
        IOCContainer.loadComponents(Bank.class.getResourceAsStream("bank-dependencies.properties"));

        //BankAccountController bankAccountController = (BankAccountController) IOCContainer.getComponent("bankAccountController");

        //BankAccount bankAccount = AccountFactory.CreateAccount(AccountType.SAVINGS, "12", "person", 6);

        //bankAccountController.CreateAccount(bankAccount);

        //System.out.println();

        try {
	    // Add the following code if you want the Look and Feel
		    // to be set to the Look and Feel of the native system.

	    try {
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    }
		    catch (Exception e) {
	    }
         //Create a new instance of our application's frame, and make it visible.
		(new BankFrm()).setVisible(true);
		}
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
    }
}
