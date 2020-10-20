package com.epam.book.logic;

import com.epam.pyramid.logic.PyramidCalculator;
import com.epam.pyramid.model.Plane;
import com.epam.pyramid.model.Point;
import com.epam.pyramid.model.Pyramid;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PyramidCalculatorTest {

    private final static double DELTA = 1e-6;

    private final static Point POINT_ONE = new Point(0, 0, 0);
    private final static Point POINT_TWO = new Point(1, 0, 0);
    private final static Point POINT_THREE = new Point(0, 1, 0);
    private final static Point POINT_FOUR = new Point(0, 0, 1);

    private final static List<Point> POINTS = Arrays.asList(POINT_ONE, POINT_TWO, POINT_THREE, POINT_FOUR);
    private final static Pyramid PYRAMID = new Pyramid(POINTS);

    private final PyramidCalculator pyramidCalculator = new PyramidCalculator();

    @Test
    public void testCalculateAreaSideSurfaceShouldCalculateWhenPyramid() {
        //when
        double actual = pyramidCalculator.calculateAreaSideSurface(PYRAMID);
        //then
        Assert.assertEquals(2.366025, actual, DELTA);
    }

    @Test
    public void testCalculateVolumeShouldCalculateWhenPyramid() {
        //when
        double actual = pyramidCalculator.calculateVolume(PYRAMID);
        //then
        Assert.assertEquals(0.166666, actual, DELTA);
    }

    @Test
    public void testCalculateRatioVolumesShouldReturnOneWhenPlaneNotCrossPyramid() {
        //given
        Plane plane = Plane.PLANE_X;
        //when
        double actual = pyramidCalculator.calculateRatioVolumes(PYRAMID, plane);
        //then
        Assert.assertEquals(0, actual, DELTA);
    }

    @Test
    public void testCalculateRatioVolumesShouldCalculate() {
        //given
        Point pointOne = new Point(4, 0, -5);
        Point pointTwo = new Point(0, 6, -5);
        Point pointThree = new Point(0, 0, -5);
        Point pointFour = new Point(0, 0, 5);
        List<Point> points = Arrays.asList(pointOne, pointTwo, pointThree, pointFour);
        Pyramid pyramid = new Pyramid(points);
        Plane plane = Plane.PLANE_Z;
        //when
        double actual = pyramidCalculator.calculateRatioVolumes(pyramid, plane);
        //then
        Assert.assertEquals(1. / 7, actual, DELTA);
    }

    @Test
    public void testIsBaseBelongedPlaneShouldTrueWhenPyramid() {
        //when
        boolean actual = pyramidCalculator.isBaseBelongedPlane(PYRAMID);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsBaseBelongedPlaneShouldFalseWhenPyramid() {
        //given
        Point pointOne = new Point(-1., -1., -1.);
        List<Point> points = Arrays.asList(pointOne, POINT_TWO, POINT_THREE, POINT_FOUR);
        Pyramid pyramid = new Pyramid(points);
        //when
        boolean actual = pyramidCalculator.isBaseBelongedPlane(pyramid);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testFindCoordinatesVectorsShouldCalculateWhenFourPoint() {
        //when
        double[][] actual = pyramidCalculator.findCoordinatesVectors(POINTS);
        //then
        Assert.assertArrayEquals(new double[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}, actual);
    }

    @Test
    public void testFindCoordinatesVectorsShouldCalculateWhenThreePoint() {
        //given
        Point pointOne = new Point(1, 1, 1);
        Point pointTwo = new Point(2, 3, 4);
        Point pointThree = new Point(0, 0, 0);
        List<Point> points = Arrays.asList(pointOne, pointTwo, pointThree);
        //when
        double[][] actual = pyramidCalculator.findCoordinatesVectors(points);
        //then
        Assert.assertArrayEquals(new double[][]{{1, 2, 3}, {-1, -1, -1}}, actual);
    }

    @Test
    public void testFindMatrixDeterminantShouldCalculateWhenMatrix() {
        //given
        double[][] matrix = new double[][]{{1, 2, -1}, {7, 8, 9}, {-5, 4, 3}};
        //when
        double actual = pyramidCalculator.findMatrixDeterminant(matrix);
        //then
        Assert.assertEquals(-212., actual, DELTA);
    }

}