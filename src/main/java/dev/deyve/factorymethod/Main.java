package dev.deyve.factorymethod;

public class Main {

    public static void main(String[] args) {
        NotificationFactory factory = new EmailNotificationFactory();
        factory.dispatch("Hello via email");

        factory = new SmsNotificationFactory();
        factory.dispatch("Hello via SMS");
    }
}
