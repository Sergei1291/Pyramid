package com.epam.pyramid.model;

public final class PyramidParameter {

    private final double areaSideSurface;
    private final double volume;

    public PyramidParameter(double areaSideSurface, double volume) {

        this.areaSideSurface = areaSideSurface;
        this.volume = volume;

    }

    public double getAreaSideSurface() {

        return areaSideSurface;
    }

    public double getVolume() {

        return volume;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(areaSideSurface);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(volume);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PyramidParameter other = (PyramidParameter) obj;
        if (Double.doubleToLongBits(areaSideSurface) != Double.doubleToLongBits(other.areaSideSurface)) {
            return false;
        }
        if (Double.doubleToLongBits(volume) != Double.doubleToLongBits(other.volume)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        return this.getClass().getSimpleName() + " [areaSideSurface=" + areaSideSurface + ", volume=" + volume + "]";
    }

}