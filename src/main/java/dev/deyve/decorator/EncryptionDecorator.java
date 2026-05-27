package dev.deyve.decorator;

public class EncryptionDecorator extends DataSourceDecorator {

    public EncryptionDecorator(DataSource wrappee) {
        super(wrappee);
    }

    @Override
    public void writeData(String data) {
        wrappee.writeData(reverse(data));
    }

    @Override
    public String readData() {
        return reverse(wrappee.readData());
    }

    private static String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
