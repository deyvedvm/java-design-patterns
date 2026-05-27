package dev.deyve.factorymethod;

public class EmailNotificationFactory extends NotificationFactory {

    @Override
    protected Notification createNotification() {
        return new EmailNotification();
    }
}
