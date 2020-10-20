package com.epam.pyramid.logic;

import com.epam.pyramid.model.Plane;
import com.epam.pyramid.model.Pyramid;

public interface Calculator {

    double calculateAreaSideSurface(Pyramid pyramid);

    double calculateVolume(Pyramid pyramid);

    double calculateRatioVolumes(Pyramid pyramid, Plane plane);

    boolean isBaseBelongedPlane(Pyramid pyramid);

}