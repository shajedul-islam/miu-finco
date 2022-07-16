package project.bank.edu.miu.asd.bank;


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
