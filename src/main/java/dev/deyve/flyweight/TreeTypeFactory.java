package dev.deyve.flyweight;

import java.util.HashMap;
import java.util.Map;

public class TreeTypeFactory {

    private final Map<String, TreeType> cache = new HashMap<>();

    public TreeType get(String name, String color, String texture) {
        String key = name + "|" + color + "|" + texture;
        return cache.computeIfAbsent(key, k -> new TreeType(name, color, texture));
    }

    public int cacheSize() {
        return cache.size();
    }
}
