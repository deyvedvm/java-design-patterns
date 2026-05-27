package dev.deyve.factorymethod;

public abstract class NotificationFactory {

    public void dispatch(String message) {
        Notification notification = createNotification();
        notification.send(message);
    }

    protected abstract Notification createNotification();
}
