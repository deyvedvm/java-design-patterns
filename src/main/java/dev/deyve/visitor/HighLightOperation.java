package dev.deyve.visitor;

public class HighLightOperation implements Operation {

    @Override
    public void apply(HeadingNode headingNode) {
        System.out.println("highlight-heading");
    }

    @Override
    public void apply(AnchorNode anchorNode) {
        System.out.println("highlight-anchor");
    }
}
