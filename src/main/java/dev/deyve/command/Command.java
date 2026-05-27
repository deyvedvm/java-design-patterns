package dev.deyve.command;

public interface Command {

    void execute();

    void undo();
}
