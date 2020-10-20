package com.epam.pyramid.logic;

import com.epam.pyramid.model.Plane;
import com.epam.pyramid.model.Point;
import com.epam.pyramid.model.Pyramid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PyramidCalculator implements Calculator {

    private final static Logger LOGGER = LogManager.getLogger();

    private final static double DELTA = 1E-9;

    private final static double PYRAMID_VOLUME_COEFFICIENT = 1. / 6;
    private final static double TRIANGLE_AREA_COEFFICIENT = 1. / 2;

    private final static int NUMBERS_VECTORS_COORDINATES = 3;
    private final static int NUMBER_POINTS_BELONG_PLANE = 3;

    private final static int INDEX_FIRST_POINT = 0;
    private final static int INDEX_SECOND_POINT = 1;
    private final static int INDEX_THIRD_POINT = 2;
    private final static int INDEX_FOURTH_POINT = 3;

    private final static int INDEX_X_COORDINATE = 0;
    private final static int INDEX_Y_COORDINATE = 1;
    private final static int INDEX_Z_COORDINATE = 2;

    @Override
    public double calculateAreaSideSurface(Pyramid pyramid) {

        List<Point> points = pyramid.getPoints();

        double areaSideSurface = 0;

        for (int i = 0; i < points.size(); i++) {

            List<Point> sideEdge = new ArrayList<Point>(points);
            sideEdge.remove(i);
            double areaSideEdge = findTriangleArea(sideEdge);
            areaSideSurface = areaSideSurface + areaSideEdge;
        }

        return areaSideSurface;
    }

    @Override
    public double calculateVolume(Pyramid pyramid) {

        List<Point> points = pyramid.getPoints();

        double[][] coordinatesVectors = findCoordinatesVectors(points);
        double determinant = findMatrixDeterminant(coordinatesVectors);

        return PYRAMID_VOLUME_COEFFICIENT * Math.abs(determinant);
    }

    @Override
    public double calculateRatioVolumes(Pyramid pyramid, Plane plane) {

        List<Point> points = pyramid.getPoints();

        Point topPyramid = findTopPyramid(points, plane);
        Point pointBasePyramid = findPointBasePyramid(points, topPyramid);

        double highPyramid = calculateHighPyramid(topPyramid, pointBasePyramid, plane);
        double highSmallPyramid = Math.abs(extractPointField(topPyramid, plane));

        if (highPyramid - highSmallPyramid < DELTA) {
            LOGGER.warn("plane " + plane + " does not cross pyramid " + pyramid);
            return 0;
        }

        double similarityCoefficient = highPyramid / highSmallPyramid;

        return Math.pow((Math.pow(similarityCoefficient, 3) - 1), -1);
    }

    @Override
    public boolean isBaseBelongedPlane(Pyramid pyramid) {

        boolean flagPlaneX = isBaseBelongedConcretePlane(pyramid, Plane.PLANE_X);
        boolean flagPlaneY = isBaseBelongedConcretePlane(pyramid, Plane.PLANE_Y);
        boolean flagPlaneZ = isBaseBelongedConcretePlane(pyramid, Plane.PLANE_Z);

        return ((flagPlaneX || flagPlaneY) || flagPlaneZ);
    }

    public double[][] findCoordinatesVectors(List<Point> points) {

        Point top = points.get(INDEX_FIRST_POINT);

        double xCoordinateTop = top.getXCoordinate();
        double yCoordinateTop = top.getYCoordinate();
        double zCoordinateTop = top.getZCoordinate();

        int numberVectors = points.size() - 1;

        double[][] coordinatesVectors = new double[numberVectors][NUMBERS_VECTORS_COORDINATES];

        for (int i = INDEX_SECOND_POINT; i < points.size(); i++) {
            Point point = points.get(i);
            double xCoordinate = point.getXCoordinate();
            double yCoordinate = point.getYCoordinate();
            double zCoordinate = point.getZCoordinate();

            coordinatesVectors[i - 1][INDEX_X_COORDINATE] = xCoordinate - xCoordinateTop;
            coordinatesVectors[i - 1][INDEX_Y_COORDINATE] = yCoordinate - yCoordinateTop;
            coordinatesVectors[i - 1][INDEX_Z_COORDINATE] = zCoordinate - zCoordinateTop;
        }

        return coordinatesVectors;
    }

    public double findMatrixDeterminant(double[][] matrix) {

        double valueOne = matrix[0][0] * matrix[1][1] * matrix[2][2];
        double valueTwo = matrix[0][2] * matrix[1][0] * matrix[2][1];
        double valueThree = matrix[0][1] * matrix[1][2] * matrix[2][0];
        double valueFour = matrix[0][2] * matrix[1][1] * matrix[2][0];
        double valueFive = matrix[0][1] * matrix[1][0] * matrix[2][2];
        double valueSix = matrix[0][0] * matrix[1][2] * matrix[2][1];

        return valueOne + valueTwo + valueThree - valueFour - valueFive - valueSix;
    }

    private double findTriangleArea(List<Point> points) {

        double[][] vectors = findCoordinatesVectors(points);

        double determinantOne = vectors[0][1] * vectors[1][2] - vectors[0][2] * vectors[1][1];
        double determinantTwo = vectors[0][0] * vectors[1][2] - vectors[0][2] * vectors[1][0];
        double determinantThree = vectors[0][0] * vectors[1][1] - vectors[0][1] * vectors[1][0];

        return TRIANGLE_AREA_COEFFICIENT * Math.hypot(Math.hypot(determinantOne, determinantTwo), determinantThree);
    }

    private boolean isBaseBelongedConcretePlane(Pyramid pyramid, Plane plane) {

        List<Point> points = pyramid.getPoints();

        int counterPoints = 0;

        for (int i = 0; i < points.size(); i++) {
            Point currentPoint = points.get(i);
            if (Math.abs(extractPointField(currentPoint, plane)) < DELTA) {
                counterPoints++;
            }
        }

        return counterPoints == NUMBER_POINTS_BELONG_PLANE;
    }

    private double extractPointField(Point point, Plane plane) {

        switch (plane) {
            case PLANE_X:
                return point.getXCoordinate();
            case PLANE_Y:
                return point.getYCoordinate();
            case PLANE_Z:
                return point.getZCoordinate();
            default:
                throw new IllegalArgumentException("illegal Plane" + plane);
        }

    }

    private Point findTopPyramid(List<Point> points, Plane plane) {

        Point pointOne = points.get(INDEX_FIRST_POINT);
        Point pointTwo = points.get(INDEX_SECOND_POINT);
        Point pointThree = points.get(INDEX_THIRD_POINT);
        Point pointFour = points.get(INDEX_FOURTH_POINT);

        double planeCoordinatePointOne = extractPointField(pointOne, plane);
        double planeCoordinatePointTwo = extractPointField(pointTwo, plane);
        double planeCoordinatePointThree = extractPointField(pointThree, plane);

        if (Math.abs(planeCoordinatePointOne - planeCoordinatePointTwo) > DELTA) {
            if (Math.abs(planeCoordinatePointOne - planeCoordinatePointThree) > DELTA) {
                return pointOne;
            } else {
                return pointTwo;
            }
        } else if (Math.abs(planeCoordinatePointOne - planeCoordinatePointThree) > DELTA) {
            return pointThree;
        } else {
            return pointFour;
        }

    }

    private Point findPointBasePyramid(List<Point> points, Point topPyramid) {

        Point pointBasePyramid = points.get(INDEX_FIRST_POINT);

        if (topPyramid.equals(pointBasePyramid)) {
            pointBasePyramid = points.get(INDEX_SECOND_POINT);
        }

        return pointBasePyramid;
    }

    private double calculateHighPyramid(Point topPyramid, Point pointBasePyramid, Plane plane) {

        double fieldPointTopPyramid = extractPointField(topPyramid, plane);
        double fieldPointBasePyramid = extractPointField(pointBasePyramid, plane);

        return Math.abs(fieldPointTopPyramid - fieldPointBasePyramid);
    }

}