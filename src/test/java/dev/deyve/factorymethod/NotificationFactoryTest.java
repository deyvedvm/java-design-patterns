package dev.deyve.factorymethod;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class NotificationFactoryTest {

    @Test
    void emailFactoryShouldProduceEmailNotification() {
        NotificationFactory factory = new EmailNotificationFactory();

        assertInstanceOf(EmailNotification.class, factory.createNotification());
    }

    @Test
    void smsFactoryShouldProduceSmsNotification() {
        NotificationFactory factory = new SmsNotificationFactory();

        assertInstanceOf(SmsNotification.class, factory.createNotification());
    }

    @Test
    void dispatchShouldDelegateToCreatedNotification() {
        var buffer = new ByteArrayOutputStream();
        var original = System.out;
        System.setOut(new PrintStream(buffer));
        try {
            new EmailNotificationFactory().dispatch("hi");
        } finally {
            System.setOut(original);
        }

        assertEquals("Email: hi", buffer.toString().trim());
    }
}
