package dev.deyve.abstractfactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class GuiFactoryTest {

    @Test
    void windowsFactoryShouldProduceWindowsFamily() {
        GuiFactory factory = new WindowsFactory();

        assertInstanceOf(WindowsButton.class, factory.createButton());
        assertInstanceOf(WindowsCheckbox.class, factory.createCheckbox());
    }

    @Test
    void macFactoryShouldProduceMacFamily() {
        GuiFactory factory = new MacFactory();

        assertInstanceOf(MacButton.class, factory.createButton());
        assertInstanceOf(MacCheckbox.class, factory.createCheckbox());
    }
}
