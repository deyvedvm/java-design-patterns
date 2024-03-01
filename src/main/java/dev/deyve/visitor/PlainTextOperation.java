package dev.deyve.visitor;

public class PlainTextOperation implements Operation {

    public void apply(HeadingNode headingNode) {
        System.out.println("text-heading");
    }

    public void apply(AnchorNode anchorNode) {
        System.out.println("text-anchor");
    }
}
