package gui;//package project.bank;


import java.awt.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import controller.AccountController;
import controller.CustomerController;
import domain.impl.Account;
import domain.impl.Customer;
import domain.impl.Entry;
import domain.impl.TransactionType;
import ioc.IOCContainer;

import javax.swing.*;

/**
 * A basic JFC based application.
 **/
public class FincoFrm extends javax.swing.JFrame {
    /****
     * init variables in the object
     ****/
    String accountnr, clientName, street, city, zip, state, accountType, clientType, amountDeposit;
    boolean newaccount;
    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    FincoFrm myframe;
    private Object rowdata[];

    public FincoFrm() {
        myframe = this;

        setTitle("Finco.");
        setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0, 0));
        setSize(600, 350);
        setVisible(false);
        JPanel1.setLayout(null);
        getContentPane().add(BorderLayout.CENTER, JPanel1);
        JPanel1.setBounds(0, 0, 584, 324);
		/*
		/Add five buttons on the pane 
		/for Adding personal account, Adding company account
		/Deposit, Withdraw and Exit from the system
		*/
        JScrollPane1 = new JScrollPane();
        model = new DefaultTableModel();
        JTable1 = new JTable(model);
        model.addColumn("AcctNr");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("State");
        model.addColumn("Email");
        model.addColumn("Amount");
        rowdata = new Object[8];
        newaccount = false;


        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12, 92, 442, 160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);
//        rowdata = new Object[8];

        JButton_PerAC.setText("Add account");
        JPanel1.add(JButton_PerAC);
        JButton_PerAC.setBounds(24, 20, 192, 33);
        //JButton_CompAC.setText("Add company account");
        //JButton_CompAC.setActionCommand("jbutton");
        //JPanel1.add(JButton_CompAC);
        JButton_CompAC.setBounds(240, 20, 190, 33);
        JButton_Deposit.setText("Deposit");
        JPanel1.add(JButton_Deposit);
        JButton_Deposit.setBounds(468, 104, 96, 33);
        JButton_Withdraw.setText("Withdraw");
        JPanel1.add(JButton_Withdraw);
        //JButton_Addinterest.setBounds(448,20,106,33);
        //JButton_Addinterest.setText("Add interest");
        //JPanel1.add(JButton_Addinterest);
        JButton_Withdraw.setBounds(468, 164, 96, 34);
        JButton_Exit.setText("Exit");
        JPanel1.add(JButton_Exit);
        JButton_Exit.setBounds(468, 248, 96, 30);
        // lineBorder1.setRoundedCorners(true);
        // lineBorder1.setLineColor(java.awt.Color.green);
        //$$ lineBorder1.move(24,312);

        JButton_PerAC.setActionCommand("jbutton");

        SymWindow aSymWindow = new SymWindow();
        this.addWindowListener(aSymWindow);
        SymAction lSymAction = new SymAction();
        JButton_Exit.addActionListener(lSymAction);
        JButton_PerAC.addActionListener(lSymAction);
        JButton_CompAC.addActionListener(lSymAction);
        JButton_Deposit.addActionListener(lSymAction);
        JButton_Withdraw.addActionListener(lSymAction);
        JButton_Addinterest.addActionListener(lSymAction);

        bindCustomerAccounts();

    }


    /*****************************************************
     * The entry point for this application.
     * Sets the Look and Feel to the System Look and Feel.
     * Creates a new JFrame1 and makes it visible.
     *****************************************************/
//	static public void main(String args[])
//	{
//		try {
//		    // Add the following code if you want the Look and Feel
//		    // to be set to the Look and Feel of the native system.
//		    
//		    try {
//		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		    } 
//		    catch (Exception e) { 
//		    }
//
//			//Create a new instance of our application's frame, and make it visible.
//			(new gui.FincoFrm()).setVisible(true);
//		} 
//		catch (Throwable t) {
//			t.printStackTrace();
//			//Ensure the application exits with an error condition.
//			System.exit(1);
//		}
//	}


    javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
    javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
    javax.swing.JButton JButton_CompAC = new javax.swing.JButton();
    javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
    javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
    javax.swing.JButton JButton_Addinterest = new javax.swing.JButton();
    javax.swing.JButton JButton_Exit = new javax.swing.JButton();

    void exitApplication() {
        try {
            this.setVisible(false);    // hide the Frame
            this.dispose();            // free the system resources
            System.exit(0);            // close the application
        } catch (Exception e) {
        }
    }

    class SymWindow extends java.awt.event.WindowAdapter {
        public void windowClosing(java.awt.event.WindowEvent event) {
            Object object = event.getSource();
            if (object == FincoFrm.this) BankFrm_windowClosing(event);
        }
    }

    void BankFrm_windowClosing(java.awt.event.WindowEvent event) {
        // to do: code goes here.

        BankFrm_windowClosing_Interaction1(event);
    }

    void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
        try {
            this.exitApplication();
        } catch (Exception e) {
        }
    }

    class SymAction implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent event) {
            Object object = event.getSource();
            if (object == JButton_Exit) JButtonExit_actionPerformed(event);
            else if (object == JButton_PerAC) JButtonPerAC_actionPerformed(event);
            else if (object == JButton_CompAC) JButtonCompAC_actionPerformed(event);
            else if (object == JButton_Deposit) JButtonDeposit_actionPerformed(event);
            else if (object == JButton_Withdraw) JButtonWithdraw_actionPerformed(event);
            else if (object == JButton_Addinterest) JButtonAddinterest_actionPerformed(event);

        }
    }

    //When the Exit button is pressed this code gets executed
    //this will exit from the system
    void JButtonExit_actionPerformed(java.awt.event.ActionEvent event) {
        System.exit(0);
    }


    void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object 
		 set the boundaries and show it 
		*/

        JDialog_AddPAcc1 pac = new JDialog_AddPAcc1(myframe);
        pac.setBounds(450, 20, 300, 330);
        pac.show();


        if (newaccount) {

            bindCustomerAccounts();

            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            newaccount = false;
        }


    }

    void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 construct a JDialog_AddCompAcc type object 
		 set the boundaries and 
		 show it 
		*/

        JDialog_AddCompAcc1 pac = new JDialog_AddCompAcc1(myframe);
        pac.setBounds(450, 20, 300, 330);
        pac.show();

        if (newaccount) {
            // add row to table
            rowdata[0] = accountnr;
            rowdata[1] = clientName;
            rowdata[2] = city;
            rowdata[3] = "C";
            rowdata[4] = accountType;
            rowdata[5] = "0";
            model.addRow(rowdata);
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            newaccount = false;
        }

    }

    void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String accnr = (String) model.getValueAt(selection, 0);

            //Show the dialog for adding deposit amount for the current mane
            JDialog_Deposit1 dep = new JDialog_Deposit1(myframe, accnr);
            dep.setBounds(430, 15, 275, 140);
            dep.show();

            if (amountDeposit != null) {
                // compute new amount
                long deposit = Long.parseLong(amountDeposit);

                AccountController accountController = (AccountController) IOCContainer.getComponent("accountController");
                accountController.addEntry(accnr, new Entry(deposit, TransactionType.Credit));

                bindCustomerAccounts();
            }
        }
    }

    void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String accnr = (String) model.getValueAt(selection, 0);

            //Show the dialog for adding withdraw amount for the current mane
            JDialog_Withdraw1 wd = new JDialog_Withdraw1(myframe, accnr);
            wd.setBounds(430, 15, 275, 140);
            wd.show();

            Object samount1 = model.getValueAt(selection, 5);
            String samount2 = samount1.toString();

            if (amountDeposit != null) {
                // compute new amount
                Double deposit = Double.parseDouble(amountDeposit);
                //String samount = (String)model.getValueAt(selection, 5);
                Double currentamount = Double.parseDouble(samount2);
                Double newamount = currentamount - deposit;
                //model.setValueAt(String.valueOf(newamount),selection, 5);

                AccountController accountController = (AccountController) IOCContainer.getComponent("accountController");

                accountController.addEntry(accnr, new Entry(deposit, TransactionType.Debit));

                bindCustomerAccounts();

                if (newamount < 0) {
                    JOptionPane.showMessageDialog(JButton_Withdraw, " Account " + accnr + " : balance is negative: $" + String.valueOf(newamount) + " !", "Warning: negative balance", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

    void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event) {
        JOptionPane.showMessageDialog(JButton_Addinterest, "Add interest to all accounts", "Add interest to all accounts", JOptionPane.WARNING_MESSAGE);

    }

    void bindCustomerAccounts() {
        if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }

        CustomerController customerController = (CustomerController) IOCContainer.getComponent("customerController");

        List<Customer> customers = customerController.getallCustomer();
        int counter = 0;

        for (Customer cu : customers) {
            for (Account ac : cu.getAccounts()) {
                rowdata = new Object[8];
                rowdata[0] = ac.getAccNumber();
                rowdata[1] = cu.getName();
                rowdata[2] = cu.getCity();
                rowdata[3] = cu.getState();
                rowdata[4] = cu.getEmail();
                rowdata[5] = ac.getBalance();
                model.addRow(rowdata);
                counter++;
            }
        }
    }
}
