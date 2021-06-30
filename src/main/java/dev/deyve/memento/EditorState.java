package dev.deyve.memento;

import lombok.Getter;
import lombok.ToString;

@Getter
public class EditorState {

    private final String content;

    public EditorState(String content) {
        this.content = content;
    }
}
