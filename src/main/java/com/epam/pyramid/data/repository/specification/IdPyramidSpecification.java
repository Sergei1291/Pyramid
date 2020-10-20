package com.epam.pyramid.data.repository.specification;

import com.epam.pyramid.logic.observer.PyramidObservable;

public class IdPyramidSpecification implements Specification {

    private int id;

    public IdPyramidSpecification(int id) {

        this.id = id;

    }

    @Override
    public boolean specified(PyramidObservable pyramidObservable) {

        int idPyramid = pyramidObservable.getId();

        return id == idPyramid;
    }

}