package com.epam.pyramid.logic.observer;

import com.epam.pyramid.logic.Calculator;
import com.epam.pyramid.logic.PyramidCalculator;
import com.epam.pyramid.model.PyramidParameter;

import java.util.HashMap;
import java.util.Map;

public class PyramidObserver implements Observer {

    private final static PyramidObserver INSTANCE = new PyramidObserver();

    private Map<Integer, PyramidParameter> map = new HashMap<>();
    private Calculator calculator = new PyramidCalculator();

    private PyramidObserver() {

    }

    public static PyramidObserver getInstance() {

        return INSTANCE;
    }

    @Override
    public void update(PyramidObservable pyramidObservable) {

        double areaSideSurface = calculator.calculateAreaSideSurface(pyramidObservable);
        double volume = calculator.calculateVolume(pyramidObservable);
        PyramidParameter pyramidParameter = new PyramidParameter(areaSideSurface, volume);

        int idPyramidObservable = pyramidObservable.getId();

        map.put(idPyramidObservable, pyramidParameter);

    }

}