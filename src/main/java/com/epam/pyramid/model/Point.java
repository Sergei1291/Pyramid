package com.epam.pyramid.model;

public final class Point {

    private final double xCoordinate;
    private final double yCoordinate;
    private final double zCoordinate;

    public Point(double xCoordinate, double yCoordinate, double zCoordinate) {

        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.zCoordinate = zCoordinate;

    }

    public double getXCoordinate() {

        return xCoordinate;
    }

    public double getYCoordinate() {

        return yCoordinate;
    }

    public double getZCoordinate() {

        return zCoordinate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(xCoordinate);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(yCoordinate);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(zCoordinate);
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
        Point other = (Point) obj;
        if (Double.doubleToLongBits(xCoordinate) != Double.doubleToLongBits(other.xCoordinate)) {
            return false;
        }
        if (Double.doubleToLongBits(yCoordinate) != Double.doubleToLongBits(other.yCoordinate)) {
            return false;
        }
        if (Double.doubleToLongBits(zCoordinate) != Double.doubleToLongBits(other.zCoordinate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        return this.getClass().getSimpleName() + " [xCoordinate = " + xCoordinate + ", y=" + yCoordinate + ", z=" + zCoordinate + "]";
    }

}