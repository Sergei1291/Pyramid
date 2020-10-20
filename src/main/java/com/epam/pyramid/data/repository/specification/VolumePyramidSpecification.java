package com.epam.pyramid.data.repository.specification;

import com.epam.pyramid.logic.Calculator;
import com.epam.pyramid.logic.observer.PyramidObservable;

public class VolumePyramidSpecification implements Specification {

    private final static double DELTA = 1e-9;

    private Calculator calculator;
    private double minBorder;
    private double maxBorder;

    public VolumePyramidSpecification(Calculator calculator, double minBorder, double maxBorder) {

        this.calculator = calculator;
        this.minBorder = minBorder;
        this.maxBorder = maxBorder;

    }

    @Override
    public boolean specified(PyramidObservable pyramidObservable) {

        double volumePyramid = calculator.calculateVolume(pyramidObservable);

        boolean flagMinBorder = volumePyramid > (minBorder - DELTA);
        boolean flagMaxBorder = volumePyramid < (maxBorder + DELTA);

        return flagMinBorder && flagMaxBorder;
    }

}