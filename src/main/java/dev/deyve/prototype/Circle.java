package dev.deyve.prototype;

public class Circle extends Shape {

    private int radius;

    public Circle() {
    }

    private Circle(Circle source) {
        this.radius = source.radius;
    }

    @Override
    public Circle clone() {
        return new Circle(this);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{radius=" + radius + "}";
    }
}
