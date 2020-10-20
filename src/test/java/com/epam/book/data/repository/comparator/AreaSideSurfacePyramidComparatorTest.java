package com.epam.book.data.repository.comparator;

import com.epam.pyramid.data.repository.comparator.AreaSideSurfacePyramidComparator;
import com.epam.pyramid.logic.Calculator;
import com.epam.pyramid.logic.PyramidCalculator;
import com.epam.pyramid.logic.observer.PyramidObservable;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class AreaSideSurfacePyramidComparatorTest {

    private final static PyramidObservable PYRAMID_OBSERVABLE = new PyramidObservable(0, null);

    @Test
    public void testCompareShouldReturnZeroWhenAbsoluteDifferenceAreasLessEqualDelta() {
        //given
        Calculator calculator = Mockito.mock(PyramidCalculator.class);
        when(calculator.calculateAreaSideSurface(any())).thenReturn(-1.000_000_001, -1.000_000_002);
        AreaSideSurfacePyramidComparator comparator = new AreaSideSurfacePyramidComparator(calculator);
        //when
        int actual = comparator.compare(PYRAMID_OBSERVABLE, PYRAMID_OBSERVABLE);
        //then
        Assert.assertEquals(0, actual);
    }

    @Test
    public void testCompareShouldReturnNegativeWhenDifferenceAreasMoreDelta() {
        //given
        Calculator calculator = Mockito.mock(PyramidCalculator.class);
        when(calculator.calculateAreaSideSurface(any())).thenReturn(-1.000_000_003, -1.000_000_001);
        AreaSideSurfacePyramidComparator comparator = new AreaSideSurfacePyramidComparator(calculator);
        //when
        int actual = comparator.compare(PYRAMID_OBSERVABLE, PYRAMID_OBSERVABLE);
        //then
        Assert.assertTrue(actual < 0);
    }

    @Test
    public void testCompareShouldReturnPositiveWhenDifferenceAreasLessNegativeDelta() {
        //given
        Calculator calculator = Mockito.mock(PyramidCalculator.class);
        when(calculator.calculateAreaSideSurface(any())).thenReturn(-1.000_000_001, -1.000_000_003);
        AreaSideSurfacePyramidComparator comparator = new AreaSideSurfacePyramidComparator(calculator);
        //when
        int actual = comparator.compare(PYRAMID_OBSERVABLE, PYRAMID_OBSERVABLE);
        //then
        Assert.assertTrue(actual > 0);
    }

}