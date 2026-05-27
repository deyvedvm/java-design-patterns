package dev.deyve.facade;

public class PaymentService {

    public boolean charge(String customerId, int amountCents) {
        return customerId != null && !customerId.isEmpty() && amountCents > 0;
    }
}
