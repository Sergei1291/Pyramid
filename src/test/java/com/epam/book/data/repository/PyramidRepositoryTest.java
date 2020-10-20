package com.epam.book.data.repository;

import com.epam.pyramid.data.DataException;
import com.epam.pyramid.data.repository.PyramidRepository;
import com.epam.pyramid.logic.observer.PyramidObservable;
import com.epam.pyramid.model.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PyramidRepositoryTest {

    private final static PyramidObservable PYRAMID_ONE = new PyramidObservable(1, null);
    private final static PyramidObservable PYRAMID_TWO = new PyramidObservable(2, null);
    private final static PyramidObservable PYRAMID_THREE = new PyramidObservable(2, new ArrayList<Point>());

    @Test
    public void testAddShouldChangeSizeWhenAddNewPyramid() throws DataException {
        //given
        PyramidRepository pyramidRepository = new PyramidRepository();
        pyramidRepository.add(PYRAMID_ONE);
        int initialSize = pyramidRepository.getSize();
        //when
        pyramidRepository.add(PYRAMID_TWO);
        //then
        int endSize = pyramidRepository.getSize();
        Assert.assertTrue(initialSize != endSize);
    }

    @Test(expected = DataException.class)//then
    public void testAddShouldThrowDataExceptionWhenRepositoryHaveIdPyramid() throws DataException {
        //given
        PyramidRepository pyramidRepository = new PyramidRepository();
        pyramidRepository.add(PYRAMID_TWO);
        //when
        pyramidRepository.add(PYRAMID_THREE);
    }

    @Test
    public void testRemoveShouldChangeSizeWhenRemovePyramid() throws DataException {
        //given
        PyramidRepository pyramidRepository = new PyramidRepository();
        pyramidRepository.add(PYRAMID_ONE);
        pyramidRepository.add(PYRAMID_TWO);
        int initialSize = pyramidRepository.getSize();
        //when
        pyramidRepository.remove(PYRAMID_TWO);
        //then
        int endSize = pyramidRepository.getSize();
        Assert.assertTrue(initialSize != endSize);
    }

    @Test(expected = DataException.class)//then
    public void testRemoveShouldThrowDataExceptionWhenRepositoryNotHaveIdPyramid() throws DataException {
        //given
        PyramidRepository pyramidRepository = new PyramidRepository();
        pyramidRepository.add(PYRAMID_ONE);
        //when
        pyramidRepository.remove(PYRAMID_TWO);
    }

    @Test(expected = DataException.class)//then
    public void testRemoveShouldThrowDataExceptionWhenRepositoryHaveIdPyramidValueNotEqual() throws DataException {
        //given
        PyramidRepository pyramidRepository = new PyramidRepository();
        pyramidRepository.add(PYRAMID_ONE);
        pyramidRepository.add(PYRAMID_TWO);
        //when
        pyramidRepository.remove(PYRAMID_THREE);
    }

    @Test(expected = DataException.class)//then
    public void testUpdateShouldThrowDataExceptionWhenRepositoryNotHaveIdPyramid() throws DataException {
        //given
        PyramidRepository pyramidRepository = new PyramidRepository();
        pyramidRepository.add(PYRAMID_ONE);
        //when
        pyramidRepository.update(PYRAMID_TWO);
    }

}