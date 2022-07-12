package notification.impl;

import ioc.IComponent;
import notification.INotification;

public class SMSNotification implements INotification, IComponent {
    @Override
    public void send(String to, String message) {
        System.out.println("Sending SMS to: " + to + " content: " + message);
    }
}
