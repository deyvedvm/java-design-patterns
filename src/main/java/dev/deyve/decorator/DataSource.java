package dev.deyve.decorator;

public interface DataSource {

    void writeData(String data);

    String readData();
}
