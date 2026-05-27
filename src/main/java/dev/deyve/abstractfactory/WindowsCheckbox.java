package dev.deyve.abstractfactory;

public class WindowsCheckbox implements Checkbox {

    @Override
    public void render() {
        System.out.println("Render Windows checkbox");
    }
}
