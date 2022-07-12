import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.AccountController;
import controller.CustomerController;
import domain.impl.Account;
import domain.impl.ConcreteAccount;
import domain.impl.ConcreteOrganization;
import domain.impl.Customer;
import factory.AbstractAccountFactory;
import factory.AccountFactory;
import factory.AccountType;
import ioc.IOCContainer;


public class Finco {
    public static void main(String[] args) throws ClassNotFoundException {
        IOCContainer.buildApplicationContext(Finco.class.getResourceAsStream("finco-dependencies.properties"));
        AccountController accountController = (AccountController) IOCContainer.componentMap.get("accountController");
        CustomerController customerController = new CustomerController();
              
        Customer customer = new ConcreteOrganization("Sabbir", "IOWA", "Fairfield", "Hola", "Doris", "sabbir@nsales.dk", 10);
        customer.AddAccount(new ConcreteAccount("02201016"));
        customer.AddAccount(new ConcreteAccount("02201017"));
        
        customerController.createCustomer(customer);
   
    }
}
