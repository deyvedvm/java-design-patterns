package dev.deyve.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject - also called Observable
 */
public class Subject {

    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers() {
        observers.forEach(Observer::update);
    }
}
