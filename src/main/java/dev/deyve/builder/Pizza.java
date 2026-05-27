package dev.deyve.builder;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private final String size;
    private final boolean cheese;
    private final List<String> toppings;

    private Pizza(Builder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.toppings = List.copyOf(builder.toppings);
    }

    public static Builder builder(String size) {
        return new Builder(size);
    }

    public String getSize() {
        return size;
    }

    public boolean hasCheese() {
        return cheese;
    }

    public List<String> getToppings() {
        return toppings;
    }

    @Override
    public String toString() {
        return "Pizza{size=" + size + ", cheese=" + cheese + ", toppings=" + toppings + "}";
    }

    public static class Builder {

        private final String size;
        private boolean cheese;
        private final List<String> toppings = new ArrayList<>();

        private Builder(String size) {
            this.size = size;
        }

        public Builder cheese(boolean cheese) {
            this.cheese = cheese;
            return this;
        }

        public Builder topping(String topping) {
            this.toppings.add(topping);
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}
