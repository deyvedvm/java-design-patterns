package dev.deyve.observer;

public class Main {

    public static void main(String[] args) {

        var dataSource = new DataSource();

        dataSource.setValue(1);

        var sheet = new SpreadSheet(dataSource);
        var sheetSpreadSheet = new SpreadSheet(dataSource);
        var chart = new Chart(dataSource);

        dataSource.addObserver(sheet);
        dataSource.addObserver(sheetSpreadSheet);
        dataSource.addObserver(chart);

        dataSource.notifyObservers();

        dataSource.setValue(2);
    }
}
