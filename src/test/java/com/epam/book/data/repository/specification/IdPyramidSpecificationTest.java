package com.epam.book.data.repository.specification;

import com.epam.pyramid.data.repository.specification.IdPyramidSpecification;
import com.epam.pyramid.data.repository.specification.Specification;
import com.epam.pyramid.logic.observer.PyramidObservable;
import org.junit.Assert;
import org.junit.Test;

public class IdPyramidSpecificationTest {

    private final static PyramidObservable PYRAMID = new PyramidObservable(100, null);

    @Test
    public void testSpecifiedShouldTrueWhenPyramidHaveIdEqualIdSpecification() {
        //given
        Specification specification = new IdPyramidSpecification(100);
        //when
        boolean actual = specification.specified(PYRAMID);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testSpecifiedShouldFalseWhenPyramidHaveIdNotEqualIdSpecification() {
        //given
        Specification specification = new IdPyramidSpecification(99);
        //when
        boolean actual = specification.specified(PYRAMID);
        //then
        Assert.assertFalse(actual);
    }

}