package dev.deyve.facade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderFacadeTest {

    @Test
    void successfulOrderShouldReserveStockChargeAndShip() {
        var inventory = new InventoryService();
        inventory.restock("SKU-1", 5);
        var shipping = new ShippingService();
        var facade = new OrderFacade(inventory, new PaymentService(), shipping);

        var tracking = facade.placeOrder("customer-1", "SKU-1", 1000, "Rua A");

        assertTrue(tracking.isPresent());
        assertTrue(tracking.get().startsWith("TRK-"));
        assertFalse(shipping.getShipments().isEmpty());
    }

    @Test
    void orderShouldFailWhenStockIsEmpty() {
        var inventory = new InventoryService();
        var facade = new OrderFacade(inventory, new PaymentService(), new ShippingService());

        var tracking = facade.placeOrder("customer-1", "SKU-1", 1000, "Rua A");

        assertTrue(tracking.isEmpty());
    }

    @Test
    void orderShouldFailWhenPaymentIsInvalid() {
        var inventory = new InventoryService();
        inventory.restock("SKU-1", 1);
        var facade = new OrderFacade(inventory, new PaymentService(), new ShippingService());

        var tracking = facade.placeOrder("", "SKU-1", 1000, "Rua A");

        assertTrue(tracking.isEmpty());
    }
}
