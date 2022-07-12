package notification;

import ioc.IComponent;

public class NotificationContext implements IComponent {
    private INotification notification;

    public void send(String to, String message) {
        notification.send(to, message);
    }

    public INotification getNotification() {
        return notification;
    }

    public void setNotification(INotification notification) {
        this.notification = notification;
    }
}
