package dev.deyve.mediator;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ArticlesDialogBoxTest {

    @Test
    void selectingAnArticleShouldFillTitleAndEnableSave() {
        var dialog = new ArticlesDialogBox();
        var buffer = new ByteArrayOutputStream();
        var original = System.out;
        System.setOut(new PrintStream(buffer));
        try {
            dialog.simulateUserInteraction();
        } finally {
            System.setOut(original);
        }

        String output = buffer.toString();
        assertTrue(output.contains("TextBox: Article 2"), output);
        assertTrue(output.contains("Button: true"), output);
    }
}
