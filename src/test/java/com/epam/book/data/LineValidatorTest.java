package com.epam.book.data;

import com.epam.pyramid.data.LineValidator;
import org.junit.Assert;
import org.junit.Test;

public class LineValidatorTest {

    private final static String LINE_CORRECT = "-1 20 -5.5555 -6 1 6.0 1.0 6.0 1.0 6.0 1.0 6.0 ";
    private final static String LINE_INVALID = "-1 20. -5.5555 -6 1 6.0 1.0 6.0 1.0 6.0 1.0 6.0 ";

    private final LineValidator lineValidator = new LineValidator();

    @Test
    public void testIsLineValidShouldTrueWhenLineValid() {
        //when
        boolean actual = lineValidator.isLineValid(LINE_CORRECT);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsLineValidShouldFalseWhenLineNotValid() {
        //when
        boolean actual = lineValidator.isLineValid(LINE_INVALID);
        //then
        Assert.assertFalse(actual);
    }

}