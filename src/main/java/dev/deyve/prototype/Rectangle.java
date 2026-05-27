package dev.deyve.prototype;

public class Rectangle extends Shape {

    private int width;
    private int height;

    public Rectangle() {
    }

    private Rectangle(Rectangle source) {
        this.width = source.width;
        this.height = source.height;
    }

    @Override
    public Rectangle clone() {
        return new Rectangle(this);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{width=" + width + ", height=" + height + "}";
    }
}
