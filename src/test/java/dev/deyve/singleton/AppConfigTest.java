package dev.deyve.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class AppConfigTest {

    @Test
    void getInstanceShouldReturnSameReference() {
        AppConfig first = AppConfig.getInstance();
        AppConfig second = AppConfig.getInstance();

        assertSame(first, second);
    }

    @Test
    void changesShouldBeVisibleAcrossReferences() {
        AppConfig.getInstance().set("feature.x", "on");

        assertEquals("on", AppConfig.getInstance().get("feature.x"));
    }
}
