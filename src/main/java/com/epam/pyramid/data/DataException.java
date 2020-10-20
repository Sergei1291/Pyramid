package com.epam.pyramid.data;

public class DataException extends Exception {

    public DataException(Exception exception) {

        super(exception);
    }

    public DataException(String message) {

        super(message);
    }

}