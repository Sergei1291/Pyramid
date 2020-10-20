package com.epam.pyramid.data.repository.comparator;

import com.epam.pyramid.logic.observer.PyramidObservable;
import com.epam.pyramid.model.Point;

import java.util.Comparator;

public class XCoordinateFirstPointPyramidComparator implements Comparator<PyramidObservable> {

    private final static int INDEX_FIRST_POINT = 0;
    private final static double DELTA = 1e-9;

    @Override
    public int compare(PyramidObservable pyramidObservableOne, PyramidObservable pyramidObservableTwo) {

        Point firstPointOne = pyramidObservableOne.getPoints(INDEX_FIRST_POINT);
        double xCoordinateOne = firstPointOne.getXCoordinate();

        Point firstPointTwo = pyramidObservableTwo.getPoints(INDEX_FIRST_POINT);
        double xCoordinateTwo = firstPointTwo.getXCoordinate();

        if ((xCoordinateTwo - xCoordinateOne) > DELTA) {
            return -1;
        } else if ((xCoordinateOne - xCoordinateTwo) > DELTA) {
            return 1;
        } else {
            return 0;
        }

    }

}