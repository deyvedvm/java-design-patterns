package dev.deyve.visitor;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HtmlDocumentTest {

    @Test
    void plainTextOperationShouldVisitEveryNode() {
        var document = new HtmlDocument();
        document.add(new HeadingNode());
        document.add(new AnchorNode());

        String output = capture(() -> document.execute(new PlainTextOperation()));

        assertTrue(output.contains("text-heading"), output);
        assertTrue(output.contains("text-anchor"), output);
    }

    @Test
    void highlightOperationShouldVisitEveryNode() {
        var document = new HtmlDocument();
        document.add(new HeadingNode());
        document.add(new AnchorNode());

        String output = capture(() -> document.execute(new HighlightOperation()));

        assertTrue(output.contains("highlight-heading"), output);
        assertTrue(output.contains("highlight-anchor"), output);
    }

    private static String capture(Runnable runnable) {
        var buffer = new ByteArrayOutputStream();
        var original = System.out;
        System.setOut(new PrintStream(buffer));
        try {
            runnable.run();
        } finally {
            System.setOut(original);
        }
        return buffer.toString();
    }
}
