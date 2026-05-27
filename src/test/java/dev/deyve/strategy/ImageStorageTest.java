package dev.deyve.strategy;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ImageStorageTest {

    @Test
    void shouldRunBothCompressorAndFilter() {
        var storage = new ImageStorage();

        var buffer = new ByteArrayOutputStream();
        var original = System.out;
        System.setOut(new PrintStream(buffer));
        try {
            storage.store("file", new JpegCompressor(), new BlackAndWhiteFilter());
        } finally {
            System.setOut(original);
        }

        String output = buffer.toString();
        assertTrue(output.contains("JPEG"), output);
        assertTrue(output.contains("B&W"), output);
    }

    @Test
    void differentStrategiesShouldProduceDifferentOutput() {
        var storage = new ImageStorage();
        var buffer = new ByteArrayOutputStream();
        var original = System.out;
        System.setOut(new PrintStream(buffer));
        try {
            storage.store("a", new PngCompressor(), new HighContrastFilter());
        } finally {
            System.setOut(original);
        }

        String output = buffer.toString();
        assertTrue(output.contains("PNG"), output);
        assertTrue(output.contains("high contrast"), output);
    }
}
