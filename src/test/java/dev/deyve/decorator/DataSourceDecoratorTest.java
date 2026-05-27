package dev.deyve.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DataSourceDecoratorTest {

    @Test
    void encryptionShouldRoundTrip() {
        DataSource source = new EncryptionDecorator(new InMemoryDataSource());

        source.writeData("hello world");

        assertEquals("hello world", source.readData());
    }

    @Test
    void underlyingStorageShouldSeeTransformedData() {
        var storage = new InMemoryDataSource();
        DataSource source = new EncryptionDecorator(storage);

        source.writeData("abc");

        assertNotEquals("abc", storage.readData());
        assertEquals("cba", storage.readData());
    }

    @Test
    void stackedDecoratorsShouldComposeAndRoundTrip() {
        DataSource source = new CompressionDecorator(
                new EncryptionDecorator(new InMemoryDataSource()));

        source.writeData("repeat repeat repeat repeat");

        assertEquals("repeat repeat repeat repeat", source.readData());
    }
}
