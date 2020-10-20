package com.epam.pyramid.model;

import java.util.List;

public class Pyramid {

    private List<Point> points;

    public Pyramid(List<Point> points) {

        this.points = points;

    }

    public List<Point> getPoints() {

        return points;
    }

    public Point getPoints(int index) {

        return points.get(index);
    }

    public void setPoints(List<Point> points) {

        this.points = points;
    }

    public void setPoints(Point point, int index) {

        points.set(index, point);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((points == null) ? 0 : points.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Pyramid other = (Pyramid) obj;
        if (points == null) {
            if (other.points != null) {
                return false;
            }
        } else if (!points.equals(other.points)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        return this.getClass().getSimpleName() + " [points=" + points + "]";
    }

}