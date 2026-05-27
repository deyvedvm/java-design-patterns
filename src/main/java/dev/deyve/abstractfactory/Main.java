package dev.deyve.abstractfactory;

public class Main {

    public static void main(String[] args) {
        GuiFactory factory = pickFactory(System.getProperty("os.name", ""));

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.render();
        checkbox.render();
    }

    private static GuiFactory pickFactory(String osName) {
        if (osName.toLowerCase().contains("mac")) {
            return new MacFactory();
        }
        return new WindowsFactory();
    }
}
