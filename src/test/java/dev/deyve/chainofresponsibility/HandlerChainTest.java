package dev.deyve.chainofresponsibility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HandlerChainTest {

    private static class RecordingHandler extends Handler {

        final String name;
        final boolean stop;
        int calls;

        RecordingHandler(String name, boolean stop, Handler next) {
            super(next);
            this.name = name;
            this.stop = stop;
        }

        @Override
        public boolean doHandle(HttpRequest request) {
            calls++;
            return stop;
        }
    }

    @Test
    void requestShouldPropagateUntilAHandlerStopsTheChain() {
        var third = new RecordingHandler("third", false, null);
        var second = new RecordingHandler("second", true, third);
        var first = new RecordingHandler("first", false, second);

        new WebServer(first).handle(new HttpRequest("admin", "1234"));

        assertEquals(1, first.calls);
        assertEquals(1, second.calls);
        assertEquals(0, third.calls);
    }

    @Test
    void authenticatorShouldStopChainOnInvalidCredentials() {
        var handler = new Authenticator(null);

        assertFalse(handler.doHandle(new HttpRequest("admin", "1234")));
        assertTrue(handler.doHandle(new HttpRequest("admin", "wrong")));
    }
}
