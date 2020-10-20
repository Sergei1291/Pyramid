package com.epam.book.data.repository.specification;

import com.epam.pyramid.data.repository.specification.FirstQuadrantPyramidSpecification;
import com.epam.pyramid.data.repository.specification.Specification;
import com.epam.pyramid.logic.observer.PyramidObservable;
import com.epam.pyramid.model.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FirstQuadrantPyramidSpecificationTest {

    private final static Point POINT_POSITIVE_COORDINATES = new Point(0, 1, -0.000_000_001);
    private final static Point POINT_NEGATIVE_COORDINATES = new Point(0, 1, -0.000_000_002);

    private final static List<Point> POINTS_POSITIVE = Arrays.asList(POINT_POSITIVE_COORDINATES);
    private final static List<Point> POINTS_NEGATIVE = Arrays.asList(POINT_NEGATIVE_COORDINATES);

    private final static PyramidObservable PYRAMID_POSITIVE = new PyramidObservable(0, POINTS_POSITIVE);
    private final static PyramidObservable PYRAMID_NEGATIVE = new PyramidObservable(0, POINTS_NEGATIVE);

    private final Specification specification = new FirstQuadrantPyramidSpecification();

    @Test
    public void testSpecifiedShouldTrueWhenPointsHavePositiveCoordinates() {
        //when
        boolean actual = specification.specified(PYRAMID_POSITIVE);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testSpecifiedShouldFalseWhenPointsHaveOneNegativeCoordinate() {
        //when
        boolean actual = specification.specified(PYRAMID_NEGATIVE);
        //then
        Assert.assertFalse(actual);
    }

}