import controller.AccountController;
import controller.CustomerController;
import domain.impl.ConcreteAccount;
import domain.impl.ConcreteOrganization;
import domain.impl.Customer;
import ioc.IOCContainer;
import notification.NotificationContext;

public class Finco {
    public static void main(String[] args) throws ClassNotFoundException {
        IOCContainer.buildApplicationContext(Finco.class.getResourceAsStream("finco-dependencies.properties"));
        AccountController accountController = (AccountController) IOCContainer.componentMap.get("accountController");
        CustomerController customerController = new CustomerController();

        Customer customer = new ConcreteOrganization("Sabbir", "IOWA", "Fairfield", "Hola", "Doris", "sabbir@nsales.dk", 10);
        customer.AddAccount(new ConcreteAccount("02201016"));
        customer.AddAccount(new ConcreteAccount("02201017"));

        customerController.createCustomer(customer);

        NotificationContext notificationContext = (NotificationContext) IOCContainer.componentMap.get("notificationContext");
        notificationContext.send("j.shajid@gmail.com", "500$ Deposited.");
    }
}
