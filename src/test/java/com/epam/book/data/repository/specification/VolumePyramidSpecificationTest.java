package com.epam.book.data.repository.specification;

import com.epam.pyramid.data.repository.specification.Specification;
import com.epam.pyramid.data.repository.specification.VolumePyramidSpecification;
import com.epam.pyramid.logic.Calculator;
import com.epam.pyramid.logic.PyramidCalculator;
import com.epam.pyramid.logic.observer.PyramidObservable;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class VolumePyramidSpecificationTest {

    private final static PyramidObservable PYRAMID = new PyramidObservable(0, null);

    @Test
    public void testSpecifiedShouldTrueWhenPyramidVolumeLiedInBordersMinMax() {
        //given
        Calculator calculator = Mockito.mock(PyramidCalculator.class);
        when(calculator.calculateVolume(any())).thenReturn(1.000_000_004);
        double minBorder = 1.000_000_005;
        double maxBorder = 2;
        Specification specification = new VolumePyramidSpecification(calculator, minBorder, maxBorder);
        //when
        boolean actual = specification.specified(PYRAMID);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testSpecifiedShouldFalseWhenPyramidVolumeNotLiedInBordersMinMax() {
        //given
        Calculator calculator = Mockito.mock(PyramidCalculator.class);
        when(calculator.calculateVolume(any())).thenReturn(1.000_000_003);
        double minBorder = 1.000_000_005;
        double maxBorder = 2;
        Specification specification = new VolumePyramidSpecification(calculator, minBorder, maxBorder);
        //when
        boolean actual = specification.specified(PYRAMID);
        //then
        Assert.assertFalse(actual);
    }

}