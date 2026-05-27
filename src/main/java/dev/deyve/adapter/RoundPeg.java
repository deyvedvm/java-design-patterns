package dev.deyve.adapter;

public class RoundPeg {

    private final int radius;

    protected RoundPeg() {
        this.radius = 0;
    }

    public RoundPeg(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }
}
