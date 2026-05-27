package dev.deyve.state;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CanvasTest {

    @Test
    void changingToolShouldChangeMouseDownBehavior() {
        var canvas = new Canvas();

        canvas.setCurrentTool(new BrushTool());
        String brushOutput = captureMouseDown(canvas);

        canvas.setCurrentTool(new EraserTool());
        String eraserOutput = captureMouseDown(canvas);

        assertTrue(brushOutput.contains("Brush"), brushOutput);
        assertTrue(eraserOutput.contains("Eraser"), eraserOutput);
    }

    @Test
    void getCurrentToolShouldReturnLastSetTool() {
        var canvas = new Canvas();
        var tool = new SelectionTool();

        canvas.setCurrentTool(tool);

        assertEquals(tool, canvas.getCurrentTool());
    }

    private static String captureMouseDown(Canvas canvas) {
        var buffer = new ByteArrayOutputStream();
        var original = System.out;
        System.setOut(new PrintStream(buffer));
        try {
            canvas.mouseDown();
        } finally {
            System.setOut(original);
        }
        return buffer.toString();
    }
}
