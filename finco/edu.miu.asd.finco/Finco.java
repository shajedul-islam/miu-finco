import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.AccountController;
import domain.impl.Account;
import domain.impl.ConcreteAccount;
import factory.AbstractAccountFactory;
import factory.AccountFactory;
import factory.AccountType;
import ioc.IOCContainer;


public class Finco {
    public static void main(String[] args) throws ClassNotFoundException {
        IOCContainer.buildApplicationContext(Finco.class.getResourceAsStream("finco-dependencies.properties"));
        AccountController accountController = (AccountController) IOCContainer.componentMap.get("accountController");
        
        Account account = new ConcreteAccount("02201019", "Sabbir", "IOWA", "Fairfield", "Hola", "Doris", "sabbir@nsales.dk", 10);
        accountController.CreateAccount(account);
   
    }
}
