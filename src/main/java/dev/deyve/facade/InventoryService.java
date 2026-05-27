package dev.deyve.facade;

import java.util.HashMap;
import java.util.Map;

public class InventoryService {

    private final Map<String, Integer> stock = new HashMap<>();

    public void restock(String sku, int quantity) {
        stock.merge(sku, quantity, Integer::sum);
    }

    public boolean reserve(String sku) {
        Integer available = stock.getOrDefault(sku, 0);
        if (available <= 0) {
            return false;
        }
        stock.put(sku, available - 1);
        return true;
    }
}
