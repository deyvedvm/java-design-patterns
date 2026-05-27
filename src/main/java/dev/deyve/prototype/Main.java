package dev.deyve.prototype;

public class Main {

    public static void main(String[] args) {
        var circle = new Circle();
        circle.setRadius(10);

        Circle copy = circle.clone();
        copy.setRadius(20);

        System.out.println(circle);
        System.out.println(copy);
        System.out.println(circle == copy);
    }
}
