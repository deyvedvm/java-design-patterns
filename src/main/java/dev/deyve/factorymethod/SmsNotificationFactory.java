package dev.deyve.factorymethod;

public class SmsNotificationFactory extends NotificationFactory {

    @Override
    protected Notification createNotification() {
        return new SmsNotification();
    }
}
