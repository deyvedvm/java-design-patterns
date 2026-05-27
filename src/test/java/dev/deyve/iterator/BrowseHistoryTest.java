package dev.deyve.iterator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BrowseHistoryTest {

    @Test
    void shouldIterateInInsertionOrder() {
        var history = new BrowseHistory();
        history.push("a");
        history.push("b");
        history.push("c");

        Iterator<String> iterator = history.createIterator();

        List<String> visited = new ArrayList<>();
        while (iterator.hasNext()) {
            visited.add(iterator.current());
            iterator.next();
        }

        assertEquals(List.of("a", "b", "c"), visited);
    }

    @Test
    void hasNextShouldBeFalseForEmptyHistory() {
        var history = new BrowseHistory();

        Iterator<String> iterator = history.createIterator();

        assertFalse(iterator.hasNext());
    }

    @Test
    void multipleIteratorsShouldBeIndependent() {
        var history = new BrowseHistory();
        history.push("a");
        history.push("b");

        Iterator<String> first = history.createIterator();
        Iterator<String> second = history.createIterator();
        first.next();

        assertTrue(second.hasNext());
        assertEquals("a", second.current());
        assertEquals("b", first.current());
    }
}
