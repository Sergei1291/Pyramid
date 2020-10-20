package com.epam.pyramid.data.repository.comparator;

import com.epam.pyramid.logic.observer.PyramidObservable;

import java.util.Comparator;

public class IdPyramidComparator implements Comparator<PyramidObservable> {

    @Override
    public int compare(PyramidObservable pyramidObservableOne, PyramidObservable pyramidObservableTwo) {

        int idPyramidOne = pyramidObservableOne.getId();
        int idPyramidTwo = pyramidObservableTwo.getId();

        return idPyramidOne - idPyramidTwo;
    }

}