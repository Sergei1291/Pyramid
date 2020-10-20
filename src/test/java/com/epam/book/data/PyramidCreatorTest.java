package com.epam.book.data;

import com.epam.pyramid.logic.PointValidator;
import com.epam.pyramid.data.PyramidCreator;
import com.epam.pyramid.model.Point;
import com.epam.pyramid.model.Pyramid;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.when;

public class PyramidCreatorTest {

    private final static String LINE_VALID = "0 0 0 1 0 0 0 1 0 0 0 1";

    private final static Point POINT_ONE = new Point(0, 0, 0);
    private final static Point POINT_TWO = new Point(1, 0, 0);
    private final static Point POINT_THREE = new Point(0, 1, 0);
    private final static Point POINT_FOUR = new Point(0, 0, 1);

    private final static List<Point> POINTS_VALID = Arrays.asList(POINT_ONE, POINT_TWO, POINT_THREE, POINT_FOUR);
    private final static Pyramid PYRAMID_VALID = new Pyramid(POINTS_VALID);

    @Test
    public void testParseShouldReturnEmptyOptionalWhenLineValidPointsNotValid() {
        //given
        PointValidator pointValidator = Mockito.mock(PointValidator.class);
        when(pointValidator.isPointsValid(anyListOf(Point.class))).thenReturn(false);
        PyramidCreator pyramidCreator = new PyramidCreator(pointValidator);
        //when
        Optional<Pyramid> actual = pyramidCreator.create(LINE_VALID);
        //then
        Optional<Pyramid> expected = Optional.empty();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testParseShouldReturnOptionalWhenLineValidPointsValid() {
        //given
        PointValidator pointValidator = Mockito.mock(PointValidator.class);
        when(pointValidator.isPointsValid(anyListOf(Point.class))).thenReturn(true);
        PyramidCreator pyramidCreator = new PyramidCreator(pointValidator);
        //when
        Optional<Pyramid> actual = pyramidCreator.create(LINE_VALID);
        //then
        Optional<Pyramid> expected = Optional.of(PYRAMID_VALID);
        Assert.assertEquals(expected, actual);
    }

}