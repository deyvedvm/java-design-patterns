package dev.deyve.abstractfactory;

public class MacButton implements Button {

    @Override
    public void render() {
        System.out.println("Render Mac button");
    }
}
