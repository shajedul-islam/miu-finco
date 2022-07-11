import controller.AccountController;
import ioc.IOCContainer;

public class Finco {
    public static void main(String[] args) {
        IOCContainer.buildApplicationContext(Finco.class.getResourceAsStream("finco-dependencies.properties"));
        AccountController accountController = (AccountController) IOCContainer.componentMap.get("accountController");
    }
}
