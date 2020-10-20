package com.epam.book.data.repository.comparator;

import com.epam.pyramid.data.repository.comparator.IdPyramidComparator;
import com.epam.pyramid.logic.observer.PyramidObservable;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;

public class IdPyramidComparatorTest {

    private final static PyramidObservable PYRAMID_FIRST = new PyramidObservable(10, null);
    private final static PyramidObservable PYRAMID_SECOND = new PyramidObservable(5, null);
    private final static PyramidObservable PYRAMID_THIRD = new PyramidObservable(5, new ArrayList<>());

    private final Comparator comparator = new IdPyramidComparator();

    @Test
    public void testCompareShouldReturnZeroWhenIdEqual() {
        //when
        int actual = comparator.compare(PYRAMID_SECOND, PYRAMID_THIRD);
        //then
        Assert.assertEquals(0, actual);
    }

    @Test
    public void testCompareShouldReturnNegativeWhenIdFirstLessSecond() {
        //when
        int actual = comparator.compare(PYRAMID_SECOND, PYRAMID_FIRST);
        //then
        Assert.assertTrue(actual < 0);
    }

    @Test
    public void testCompareShouldReturnPositiveWhenIdFirstMoreSecond() {
        //when
        int actual = comparator.compare(PYRAMID_FIRST, PYRAMID_SECOND);
        //then
        Assert.assertTrue(actual > 0);
    }

}