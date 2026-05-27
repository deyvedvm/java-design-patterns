package dev.deyve.facade;

import java.util.ArrayList;
import java.util.List;

public class ShippingService {

    private final List<String> shipments = new ArrayList<>();

    public String ship(String sku, String address) {
        String trackingCode = "TRK-" + (shipments.size() + 1);
        shipments.add(trackingCode + ":" + sku + "->" + address);
        return trackingCode;
    }

    public List<String> getShipments() {
        return List.copyOf(shipments);
    }
}
