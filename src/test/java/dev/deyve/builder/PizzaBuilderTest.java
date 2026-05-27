package dev.deyve.builder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PizzaBuilderTest {

    @Test
    void shouldBuildPizzaWithFluentApi() {
        Pizza pizza = Pizza.builder("large")
                .cheese(true)
                .topping("pepperoni")
                .topping("mushrooms")
                .build();

        assertEquals("large", pizza.getSize());
        assertTrue(pizza.hasCheese());
        assertEquals(List.of("pepperoni", "mushrooms"), pizza.getToppings());
    }

    @Test
    void resultingToppingsListShouldBeImmutable() {
        Pizza pizza = Pizza.builder("small").topping("olives").build();

        assertThrows(UnsupportedOperationException.class,
                () -> pizza.getToppings().add("anchovies"));
    }
}
