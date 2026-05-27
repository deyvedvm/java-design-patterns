package dev.deyve.memento;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EditorTest {

    @Test
    void shouldRestorePreviousContentFromHistory() {
        var editor = new Editor();
        var history = new History();

        editor.setContent("a");
        history.push(editor.createState());

        editor.setContent("b");
        history.push(editor.createState());

        editor.setContent("c");
        editor.restore(history.pop());

        assertEquals("b", editor.getContent());
    }

    @Test
    void poppingShouldShrinkHistory() {
        var editor = new Editor();
        var history = new History();

        editor.setContent("a");
        history.push(editor.createState());
        editor.setContent("b");
        history.push(editor.createState());

        assertEquals(2, history.size());
        history.pop();
        assertEquals(1, history.size());
    }
}
