package dev.deyve.facade;

import java.util.Optional;

public class OrderFacade {

    private final InventoryService inventory;
    private final PaymentService payment;
    private final ShippingService shipping;

    public OrderFacade(InventoryService inventory, PaymentService payment, ShippingService shipping) {
        this.inventory = inventory;
        this.payment = payment;
        this.shipping = shipping;
    }

    public Optional<String> placeOrder(String customerId, String sku, int amountCents, String address) {
        if (!inventory.reserve(sku)) {
            return Optional.empty();
        }
        if (!payment.charge(customerId, amountCents)) {
            return Optional.empty();
        }
        return Optional.of(shipping.ship(sku, address));
    }
}
