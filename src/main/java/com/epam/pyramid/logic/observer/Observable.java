package com.epam.pyramid.logic.observer;

public interface Observable {

    void add(Observer observer);

    void notifyObservers();

}