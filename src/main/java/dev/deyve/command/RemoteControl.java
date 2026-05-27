package dev.deyve.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoteControl {

    private final Deque<Command> history = new ArrayDeque<>();

    public void submit(Command command) {
        command.execute();
        history.push(command);
    }

    public void undoLast() {
        if (history.isEmpty()) {
            return;
        }
        history.pop().undo();
    }

    public int historySize() {
        return history.size();
    }
}
