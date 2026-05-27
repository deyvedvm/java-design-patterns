package dev.deyve.bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RemoteControlTest {

    @Test
    void basicRemoteShouldTogglePowerOnAnyDevice() {
        var tv = new Tv();
        var remote = new RemoteControl(tv);

        remote.togglePower();
        assertTrue(tv.isEnabled());
        remote.togglePower();
        assertFalse(tv.isEnabled());
    }

    @Test
    void sameRemoteShouldWorkWithDifferentDevices() {
        var radio = new Radio();
        var remote = new RemoteControl(radio);

        remote.togglePower();
        assertTrue(radio.isEnabled());
    }

    @Test
    void advancedRemoteShouldExtendBasicCapabilities() {
        var tv = new Tv();
        var advanced = new AdvancedRemoteControl(tv);

        advanced.volumeUp();
        int afterUp = tv.getVolume();
        advanced.mute();

        assertEquals(0, tv.getVolume());
        assertTrue(afterUp > 0);
    }
}
