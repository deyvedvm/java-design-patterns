package dev.deyve.observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataSourceTest {

    private static class RecordingObserver implements Observer {

        int updates;

        @Override
        public void update() {
            updates++;
        }
    }

    @Test
    void shouldNotifyAllObserversWhenValueChanges() {
        var dataSource = new DataSource();
        var first = new RecordingObserver();
        var second = new RecordingObserver();
        dataSource.addObserver(first);
        dataSource.addObserver(second);

        dataSource.setValue(42);

        assertEquals(1, first.updates);
        assertEquals(1, second.updates);
        assertEquals(42, dataSource.getValue());
    }

    @Test
    void removedObserverShouldNoLongerBeNotified() {
        var dataSource = new DataSource();
        var observer = new RecordingObserver();
        dataSource.addObserver(observer);

        dataSource.setValue(1);
        dataSource.removeObserver(observer);
        dataSource.setValue(2);

        assertEquals(1, observer.updates);
    }
}
