package com.epam.pyramid.data.repository.specification;

import com.epam.pyramid.logic.observer.PyramidObservable;

public interface Specification {

    boolean specified(PyramidObservable pyramidObservable);

}