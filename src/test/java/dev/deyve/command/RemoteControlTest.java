package dev.deyve.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RemoteControlTest {

    @Test
    void submittingCommandShouldExecuteAndRecordIt() {
        var light = new Light();
        var remote = new RemoteControl();

        remote.submit(new TurnOnLightCommand(light));

        assertTrue(light.isOn());
        assertEquals(1, remote.historySize());
    }

    @Test
    void undoShouldReverseLastCommand() {
        var light = new Light();
        var remote = new RemoteControl();

        remote.submit(new TurnOnLightCommand(light));
        remote.undoLast();

        assertFalse(light.isOn());
        assertEquals(0, remote.historySize());
    }

    @Test
    void undoShouldUnwindCommandsInReverseOrder() {
        var light = new Light();
        var remote = new RemoteControl();

        remote.submit(new TurnOnLightCommand(light));
        remote.submit(new TurnOffLightCommand(light));
        remote.submit(new TurnOnLightCommand(light));

        assertTrue(light.isOn());
        remote.undoLast();
        assertFalse(light.isOn());
        remote.undoLast();
        assertTrue(light.isOn());
        remote.undoLast();
        assertFalse(light.isOn());
    }

    @Test
    void undoOnEmptyHistoryShouldBeNoop() {
        var remote = new RemoteControl();

        remote.undoLast();

        assertEquals(0, remote.historySize());
    }
}
