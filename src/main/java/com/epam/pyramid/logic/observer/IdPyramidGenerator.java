package com.epam.pyramid.logic.observer;

public class IdPyramidGenerator {

    private static int id = 1;

    public static int getId() {

        return id++;
    }

}