package com.epam.pyramid.data.repository.specification;

import com.epam.pyramid.model.Point;
import com.epam.pyramid.logic.observer.PyramidObservable;

import java.util.Iterator;
import java.util.List;

public class FirstQuadrantPyramidSpecification implements Specification {

    private final static double DELTA = -1e-9;

    @Override
    public boolean specified(PyramidObservable pyramidObservable) {

        List<Point> points = pyramidObservable.getPoints();

        Iterator<Point> iterator = points.iterator();

        while (iterator.hasNext()) {
            Point currentPoint = iterator.next();

            double xCoordinate = currentPoint.getXCoordinate();
            if (xCoordinate < DELTA) {
                return false;
            }

            double yCoordinate = currentPoint.getYCoordinate();
            if (yCoordinate < DELTA) {
                return false;
            }

            double zCoordinate = currentPoint.getZCoordinate();
            if (zCoordinate < DELTA) {
                return false;
            }

        }

        return true;
    }

}