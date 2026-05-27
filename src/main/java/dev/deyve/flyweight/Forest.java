package dev.deyve.flyweight;

import java.util.ArrayList;
import java.util.List;

public class Forest {

    private final TreeTypeFactory factory = new TreeTypeFactory();
    private final List<Tree> trees = new ArrayList<>();

    public void plant(int x, int y, String name, String color, String texture) {
        trees.add(new Tree(x, y, factory.get(name, color, texture)));
    }

    public int treeCount() {
        return trees.size();
    }

    public int distinctTypes() {
        return factory.cacheSize();
    }
}
