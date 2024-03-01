package dev.deyve.visitor;

import java.util.ArrayList;
import java.util.List;

public class HtmlDocument {

    private final List<HtmlNode> nodes = new ArrayList<>();

    public void add(HtmlNode node) {
        nodes.add(node);
    }

    public void execute(Operation operation) {
        nodes.forEach(node -> node.execute(operation));
    }
}
