package dev.deyve.interpreter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpressionTest {

    @Test
    void numberExpressionShouldReturnItsValue() {
        assertEquals(42, new NumberExpression(42).interpret());
    }

    @Test
    void addShouldSumChildren() {
        Expression expr = new AddExpression(new NumberExpression(5), new NumberExpression(3));

        assertEquals(8, expr.interpret());
    }

    @Test
    void subtractShouldComputeDifference() {
        Expression expr = new SubtractExpression(new NumberExpression(10), new NumberExpression(4));

        assertEquals(6, expr.interpret());
    }

    @Test
    void nestedExpressionsShouldBeInterpretedRecursively() {
        // (5 + 3) - (2 + 1) = 5
        Expression expr = new SubtractExpression(
                new AddExpression(new NumberExpression(5), new NumberExpression(3)),
                new AddExpression(new NumberExpression(2), new NumberExpression(1)));

        assertEquals(5, expr.interpret());
    }
}
