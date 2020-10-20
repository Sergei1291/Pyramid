package com.epam.pyramid.logic.observer;

import com.epam.pyramid.model.Point;
import com.epam.pyramid.model.Pyramid;

import java.util.ArrayList;
import java.util.List;

public class PyramidObservable extends Pyramid implements Observable {

    private final int id;
    private List<Observer> observers = new ArrayList<>();

    public PyramidObservable(int id, List<Point> points) {

        super(points);

        this.id = id;

    }

    public int getId() {

        return id;
    }

    @Override
    public void setPoints(List<Point> points) {

        super.setPoints(points);

        notifyObservers();

    }

    @Override
    public void setPoints(Point point, int index) {

        super.setPoints(point, index);

        notifyObservers();

    }

    @Override
    public void add(Observer observer) {

        if (observers.contains(observer)) {
            return;
        }
        observers.add(observer);

    }

    @Override
    public void notifyObservers() {

        for (Observer observer : observers) {
            observer.update(this);
        }

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + id;
        result = prime * result + ((observers == null) ? 0 : observers.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PyramidObservable other = (PyramidObservable) obj;
        if (id != other.id) {
            return false;
        }
        if (observers == null) {
            if (other.observers != null) {
                return false;
            }
        } else if (!observers.equals(other.observers)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        return super.toString() + " [id=" + id + ", observers=" + observers + "]";
    }

}