import controller.AccountController;
import ioc.IOCContainer;

public class Finco {
    public static void main(String[] args) {
        IOCContainer.buildApplicationContext();
        AccountController accountController = (AccountController) IOCContainer.componentMap.get("accountController");

    }
}
