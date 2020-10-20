package com.epam.book.data;

import com.epam.pyramid.data.DataException;
import com.epam.pyramid.data.FileDataReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FileDataReaderTest {

    private final static String DATA = "src/test/resources/dataFileDataReaderTest.txt";
    private final static String FILE_NOT_EXIST = "src/test/resources/doesNotExist.txt";

    private final static String FIRST_LINE = "first line";
    private final static String SECOND_LINE = "second line!!!  ";
    private final static String THIRD_LINE = "third line";
    private final static List<String> LINES = Arrays.asList(FIRST_LINE, SECOND_LINE, THIRD_LINE);

    private final FileDataReader fileDataReader = new FileDataReader();

    @Test
    public void testReadLinesShouldReadFile() throws DataException {
        //when
        List<String> actual = fileDataReader.readLines(DATA);
        //then
        Assert.assertEquals(LINES, actual);
    }

    @Test(expected = DataException.class)//then
    public void testReadLinesShouldThrowDataExceptionWhenFileNotExist() throws DataException {
        //when
        fileDataReader.readLines(FILE_NOT_EXIST);
    }

}