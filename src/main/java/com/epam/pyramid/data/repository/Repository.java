package com.epam.pyramid.data.repository;

import com.epam.pyramid.data.DataException;
import com.epam.pyramid.data.repository.specification.Specification;
import com.epam.pyramid.logic.observer.PyramidObservable;

import java.util.Comparator;
import java.util.List;

public interface Repository {

    void add(PyramidObservable pyramidObservable) throws DataException;

    void remove(PyramidObservable pyramidObservable) throws DataException;

    void update(PyramidObservable pyramidObservable) throws DataException;

    List<PyramidObservable> query(Specification specification);

    List<PyramidObservable> sort(Comparator comparator);

}