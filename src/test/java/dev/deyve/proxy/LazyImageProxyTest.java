package dev.deyve.proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LazyImageProxyTest {

    @BeforeEach
    void resetLoadCounter() {
        RealImage.resetLoadCount();
    }

    @Test
    void creatingProxyShouldNotLoadRealImage() {
        new LazyImageProxy("photo.png");

        assertEquals(0, RealImage.getLoadCount());
    }

    @Test
    void firstDisplayShouldLoadOnce() {
        var proxy = new LazyImageProxy("photo.png");

        proxy.display();

        assertEquals(1, RealImage.getLoadCount());
        assertTrue(proxy.isLoaded());
    }

    @Test
    void subsequentDisplaysShouldReuseLoadedImage() {
        var proxy = new LazyImageProxy("photo.png");

        proxy.display();
        proxy.display();
        proxy.display();

        assertEquals(1, RealImage.getLoadCount());
    }

    @Test
    void independentProxiesShouldEachLoadOnce() {
        var first = new LazyImageProxy("a.png");
        var second = new LazyImageProxy("b.png");

        assertFalse(first.isLoaded());
        assertFalse(second.isLoaded());

        first.display();
        second.display();

        assertEquals(2, RealImage.getLoadCount());
    }
}
