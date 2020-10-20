package com.epam.pyramid.data;

public class LineValidator {

    private final static String REGEX = "(-?\\p{Digit}+(\\.\\p{Digit}+)?\\s+){12}";

    public boolean isLineValid(String line) {

        return line.matches(REGEX);
    }

}