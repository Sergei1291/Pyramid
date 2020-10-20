package com.epam.pyramid.data;

import com.epam.pyramid.logic.PointValidator;
import com.epam.pyramid.model.Point;
import com.epam.pyramid.model.Pyramid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PyramidCreator {

    private final static Logger LOGGER = LogManager.getLogger();

    private final static String LINE_SEPARATOR = "[ ]+";

    private final PointValidator pointValidator;

    public PyramidCreator(PointValidator pointValidator) {

        this.pointValidator = pointValidator;

    }

    public Optional<Pyramid> create(String line) {

        List<Point> points = parsePoints(line);

        if (!pointValidator.isPointsValid(points)) {
            String loggerMessage = String.format("invalid points from line = (%s) for creating Pyramid", line);
            LOGGER.warn(loggerMessage);
            return Optional.empty();
        }

        Pyramid pyramid = new Pyramid(points);

        return Optional.of(pyramid);
    }

    private List<Point> parsePoints(String line) {

        String[] numbers = line.split(LINE_SEPARATOR);

        List<Point> points = new ArrayList<>();

        int indexNumbers = 0;

        while (indexNumbers < numbers.length) {
            double xCoordinate = Double.parseDouble(numbers[indexNumbers++]);
            double yCoordinate = Double.parseDouble(numbers[indexNumbers++]);
            double zCoordinate = Double.parseDouble(numbers[indexNumbers++]);
            Point currentPoint = new Point(xCoordinate, yCoordinate, zCoordinate);

            points.add(currentPoint);
        }

        return points;
    }

}