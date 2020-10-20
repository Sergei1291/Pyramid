package com.epam.pyramid.data.repository.comparator;

import com.epam.pyramid.logic.Calculator;
import com.epam.pyramid.logic.observer.PyramidObservable;

import java.util.Comparator;

public class AreaSideSurfacePyramidComparator implements Comparator<PyramidObservable> {

    private final static double DELTA = 1e-9;
    private Calculator calculator;

    public AreaSideSurfacePyramidComparator(Calculator calculator) {

        this.calculator = calculator;

    }

    @Override
    public int compare(PyramidObservable pyramidObservableOne, PyramidObservable pyramidObservableTwo) {

        double areaSideSurfaceOne = calculator.calculateAreaSideSurface(pyramidObservableOne);
        double areaSideSurfaceTwo = calculator.calculateAreaSideSurface(pyramidObservableTwo);

        if ((areaSideSurfaceTwo - areaSideSurfaceOne) > DELTA) {
            return -1;
        } else if ((areaSideSurfaceOne - areaSideSurfaceTwo) > DELTA) {
            return 1;
        } else {
            return 0;
        }

    }

}