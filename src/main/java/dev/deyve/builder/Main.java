package dev.deyve.builder;

public class Main {

    public static void main(String[] args) {
        Pizza pizza = Pizza.builder("large")
                .cheese(true)
                .topping("pepperoni")
                .topping("mushrooms")
                .build();

        System.out.println(pizza);
    }
}
