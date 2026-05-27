package dev.deyve.abstractfactory;

public class WindowsButton implements Button {

    @Override
    public void render() {
        System.out.println("Render Windows button");
    }
}
