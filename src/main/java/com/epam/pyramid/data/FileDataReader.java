package com.epam.pyramid.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataReader implements DataReader {

    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public List<String> readLines(String fileName) throws DataException {

        BufferedReader bufferedReader = null;
        List<String> lines = new ArrayList<>();

        try {

            bufferedReader = new BufferedReader(new FileReader(fileName));

            String line = bufferedReader.readLine();

            while (line != null) {
                lines.add(line);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            throw new DataException(e);
        } finally {

            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }

        }

        return lines;
    }

}