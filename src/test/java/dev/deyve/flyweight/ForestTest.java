package dev.deyve.flyweight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class ForestTest {

    @Test
    void factoryShouldReturnSameInstanceForSameKey() {
        var factory = new TreeTypeFactory();

        TreeType first = factory.get("oak", "green", "rough");
        TreeType second = factory.get("oak", "green", "rough");

        assertSame(first, second);
    }

    @Test
    void differentKeysShouldYieldDistinctInstances() {
        var factory = new TreeTypeFactory();

        TreeType oak = factory.get("oak", "green", "rough");
        TreeType pine = factory.get("pine", "green", "smooth");

        assertEquals(2, factory.cacheSize());
        assertEquals(oak.getName(), "oak");
        assertEquals(pine.getName(), "pine");
    }

    @Test
    void forestShouldShareTypesAcrossThousandsOfTrees() {
        var forest = new Forest();
        for (int i = 0; i < 1000; i++) {
            forest.plant(i, i, "oak", "green", "rough");
            forest.plant(i, -i, "pine", "green", "smooth");
        }

        assertEquals(2000, forest.treeCount());
        assertEquals(2, forest.distinctTypes());
    }
}
