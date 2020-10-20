package com.epam.book.logic;

import com.epam.pyramid.logic.PointValidator;
import com.epam.pyramid.logic.PyramidCalculator;

import com.epam.pyramid.model.Point;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

public class PointValidatorTest {

    private final static double DELTA = 1E-9;

    @Test
    public void testIsPointsValidShouldTrueWhenPointsValid() {
        //given
        PyramidCalculator pyramidCalculator = Mockito.mock(PyramidCalculator.class);
        when(pyramidCalculator.findCoordinatesVectors(anyListOf(Point.class))).thenReturn(new double[0][0]);
        when(pyramidCalculator.findMatrixDeterminant(any())).thenReturn(2 * DELTA);
        PointValidator pointValidator = new PointValidator(pyramidCalculator);
        //when
        boolean actual = pointValidator.isPointsValid(anyListOf(Point.class));
        //
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsPointsValidShouldFalseWhenPointsNotValid() {
        //given
        PyramidCalculator pyramidCalculator = Mockito.mock(PyramidCalculator.class);
        when(pyramidCalculator.findCoordinatesVectors(anyListOf(Point.class))).thenReturn(new double[0][0]);
        when(pyramidCalculator.findMatrixDeterminant(any())).thenReturn(DELTA);
        PointValidator pointValidator = new PointValidator(pyramidCalculator);
        //when
        boolean actual = pointValidator.isPointsValid(anyListOf(Point.class));
        //
        Assert.assertFalse(actual);
    }

}