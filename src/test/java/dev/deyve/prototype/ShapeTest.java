package dev.deyve.prototype;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class ShapeTest {

    @Test
    void circleCloneShouldBeIndependentCopy() {
        var original = new Circle();
        original.setRadius(10);

        Circle copy = original.clone();

        assertNotSame(original, copy);
        assertEquals(original.getRadius(), copy.getRadius());
    }

    @Test
    void mutatingCloneShouldNotAffectOriginal() {
        var original = new Circle();
        original.setRadius(10);

        Circle copy = original.clone();
        copy.setRadius(20);

        assertEquals(10, original.getRadius());
        assertEquals(20, copy.getRadius());
    }

    @Test
    void rectangleCloneShouldCopyBothDimensions() {
        var original = new Rectangle();
        original.setWidth(5);
        original.setHeight(7);

        Rectangle copy = original.clone();

        assertEquals(5, copy.getWidth());
        assertEquals(7, copy.getHeight());
    }
}
