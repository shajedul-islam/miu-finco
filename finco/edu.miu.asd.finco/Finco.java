import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.AccountController;
import controller.CustomerController;
import domain.impl.ConcreteAccount;
import domain.impl.ConcreteOrganization;
import domain.impl.Customer;
import domain.impl.Entry;
import domain.impl.TransactionType;
import factory.AbstractAccountFactory;
import factory.AccountFactory;
import factory.AccountType;
import ioc.IOCContainer;
import notification.NotificationContext;

public class Finco {
    public static void main(String[] args) throws ClassNotFoundException {
        IOCContainer.buildApplicationContext(Finco.class.getResourceAsStream("finco-dependencies.properties"));
        AccountController accountController = (AccountController) IOCContainer.componentMap.get("accountController");
        CustomerController customerController = new CustomerController();

        /*Customer customer = new ConcreteOrganization("Sabbir", "IOWA", "Fairfield", "Hola", "Doris", "sabbir@nsales.dk", 10);
        customer.AddAccount(new ConcreteAccount("02201016"));
        customer.AddAccount(new ConcreteAccount("02201017"));

        customerController.createCustomer(customer);
*/
        // accountController.addEntry("02201016", new Entry(new Date(2022,01,01), 100, TransactionType.Credit ));

        NotificationContext notificationContext = (NotificationContext) IOCContainer.componentMap.get("notificationContext");
        notificationContext.send("j.shajid@gmail.com", "500$ Deposited.");
    }
}
