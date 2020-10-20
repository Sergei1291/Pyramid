package com.epam.pyramid.logic;

import com.epam.pyramid.model.Point;

import java.util.List;

public class PointValidator {

    private final static double DELTA = 1E-9;

    private final PyramidCalculator pyramidCalculator;

    public PointValidator(PyramidCalculator pyramidCalculator) {

        this.pyramidCalculator = pyramidCalculator;

    }

    public boolean isPointsValid(List<Point> points) {

        double[][] coordinatesVectors = pyramidCalculator.findCoordinatesVectors(points);
        double matrixDeterminant = pyramidCalculator.findMatrixDeterminant(coordinatesVectors);

        return Math.abs(matrixDeterminant) > DELTA;
    }

}