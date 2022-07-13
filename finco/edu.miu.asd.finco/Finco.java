import controller.AccountController;
import controller.CustomerController;
import domain.impl.Entry;
import domain.impl.TransactionType;
import ioc.IOCContainer;
import notification.NotificationContext;

import java.util.Date;

import javax.swing.UIManager;

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
        //accountController.addEntry("02201016", new Entry(7.2, TransactionType.Debit ));

        //NotificationContext notificationContext = (NotificationContext) IOCContainer.componentMap.get("notificationContext");
        //notificationContext.send("j.shajid@gmail.com", "500$ Deposited.");
        
        try {
		    // Add the following code if you want the Look and Feel
		    // to be set to the Look and Feel of the native system.
		    
		    try {
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (Exception e) { 
		    }

			//Create a new instance of our application's frame, and make it visible.
			(new FincoFrm()).setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
    }
}
