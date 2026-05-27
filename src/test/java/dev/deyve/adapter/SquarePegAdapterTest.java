package dev.deyve.adapter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SquarePegAdapterTest {

    @Test
    void smallSquarePegShouldFitRoundHoleViaAdapter() {
        var hole = new RoundHole(5);
        var smallSquare = new SquarePeg(5);

        assertTrue(hole.fits(new SquarePegAdapter(smallSquare)));
    }

    @Test
    void largeSquarePegShouldNotFitRoundHole() {
        var hole = new RoundHole(5);
        var bigSquare = new SquarePeg(10);

        assertFalse(hole.fits(new SquarePegAdapter(bigSquare)));
    }

    @Test
    void roundHoleAlsoAcceptsPlainRoundPegs() {
        var hole = new RoundHole(5);

        assertTrue(hole.fits(new RoundPeg(5)));
        assertFalse(hole.fits(new RoundPeg(6)));
    }
}
