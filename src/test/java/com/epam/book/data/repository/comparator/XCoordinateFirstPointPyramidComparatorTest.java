package com.epam.book.data.repository.comparator;

import com.epam.pyramid.data.repository.comparator.XCoordinateFirstPointPyramidComparator;
import com.epam.pyramid.logic.observer.PyramidObservable;
import com.epam.pyramid.model.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class XCoordinateFirstPointPyramidComparatorTest {

    private final static Point POINT_ONE = new Point(1.000_000_001, 2, 3);
    private final static Point POINT_TWO = new Point(1.000_000_002, 0, 0);
    private final static Point POINT_THREE = new Point(1.000_000_003, 2, 3);

    private final static List<Point> POINTS_ONE = Arrays.asList(POINT_ONE, POINT_THREE);
    private final static List<Point> POINTS_TWO = Arrays.asList(POINT_TWO, POINT_THREE);
    private final static List<Point> POINTS_THREE = Arrays.asList(POINT_THREE, POINT_THREE);

    private final static PyramidObservable PYRAMID_ONE = new PyramidObservable(0, POINTS_ONE);
    private final static PyramidObservable PYRAMID_TWO = new PyramidObservable(0, POINTS_TWO);
    private final static PyramidObservable PYRAMID_THREE = new PyramidObservable(0, POINTS_THREE);

    private final XCoordinateFirstPointPyramidComparator comparator = new XCoordinateFirstPointPyramidComparator();

    @Test
    public void testCompareShouldReturnZeroWhenAbsoluteDifferenceXCoordinatesFirstPointsLessEqualDelta() {
        //when
        int actual = comparator.compare(PYRAMID_ONE, PYRAMID_TWO);
        //then
        Assert.assertEquals(0, actual);
    }

    @Test
    public void testCompareShouldReturnNegativeWhenDifferenceXCoordinatesFirstPointsMoreDelta() {
        //when
        int actual = comparator.compare(PYRAMID_ONE, PYRAMID_THREE);
        //then
        Assert.assertTrue(actual < 0);
    }

    @Test
    public void testCompareShouldReturnPositiveWhenDifferenceXCoordinatesFirstPointsLessNegativeDelta() {
        //when
        int actual = comparator.compare(PYRAMID_THREE, PYRAMID_ONE);
        //then
        Assert.assertTrue(actual > 0);
    }

}