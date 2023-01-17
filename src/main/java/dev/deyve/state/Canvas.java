package dev.deyve.state;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Canvas {

    private Tool currentTool;

    public void mouseDown() {
        currentTool.mouseDown();
    }

    public void mouseUp() {
        currentTool.mouseUp();
    }
}
