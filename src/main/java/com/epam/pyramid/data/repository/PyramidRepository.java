package com.epam.pyramid.data.repository;

import com.epam.pyramid.data.DataException;
import com.epam.pyramid.data.repository.specification.Specification;
import com.epam.pyramid.logic.observer.PyramidObservable;

import java.util.*;

public class PyramidRepository implements Repository {

    private Map<Integer, PyramidObservable> map = new HashMap<>();

    @Override
    public void add(PyramidObservable pyramidObservable) throws DataException {

        int idPyramid = pyramidObservable.getId();

        PyramidObservable pyramidValue = map.get(idPyramid);

        if (pyramidValue != null) {
            throw new DataException("map yet has pyramidObservable with id = " + idPyramid);
        }

        map.put(idPyramid, pyramidObservable);

    }

    @Override
    public void remove(PyramidObservable pyramidObservable) throws DataException {

        int idPyramid = pyramidObservable.getId();

        PyramidObservable pyramidValue = map.get(idPyramid);

        if (pyramidValue == null) {
            throw new DataException("map does not have pyramidObservable with id = " + idPyramid);
        }

        if (!pyramidValue.equals(pyramidObservable)) {
            throw new DataException("map have equal key pyramidObservable, but objects values are not equal");
        }

        map.remove(idPyramid);

    }

    @Override
    public void update(PyramidObservable pyramidObservable) throws DataException {

        int idPyramid = pyramidObservable.getId();

        PyramidObservable pyramidValue = map.get(idPyramid);

        if (pyramidValue == null) {
            throw new DataException("map does not have pyramidObservable with id = " + idPyramid);
        }

        map.put(idPyramid, pyramidObservable);

    }

    @Override
    public List<PyramidObservable> query(Specification specification) {

        List<PyramidObservable> specificPyramids = new ArrayList<>();

        Collection<PyramidObservable> pyramids = map.values();

        for (PyramidObservable pyramidObservable : pyramids) {
            if (specification.specified(pyramidObservable)) {
                specificPyramids.add(pyramidObservable);
            }
        }

        return specificPyramids;
    }

    @Override
    public List<PyramidObservable> sort(Comparator comparator) {

        Collection<PyramidObservable> pyramids = map.values();

        List<PyramidObservable> sortedPyramids = new ArrayList<>(pyramids);

        Collections.sort(sortedPyramids, comparator);

        return sortedPyramids;
    }

    public int getSize() {

        return map.size();
    }

}