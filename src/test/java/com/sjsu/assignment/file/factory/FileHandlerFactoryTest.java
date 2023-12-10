package com.sjsu.assignment.file.factory;

import com.sjsu.assignment.file.constants.FileExtensionType;
import com.sjsu.assignment.file.handler.CSVHandler;
import com.sjsu.assignment.file.handler.FileHandler;
import com.sjsu.assignment.file.handler.JsonHandler;
import com.sjsu.assignment.file.handler.XMLHandler;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;

public class FileHandlerFactoryTest {

    @Test
    public void testCreateFileHandlerCSV() {
        Optional<FileHandler> fileHandler = FileHandlerFactory.createFileHandler(FileExtensionType.CSV.getType());

        Assert.assertTrue(fileHandler.isPresent());
        Assert.assertTrue(fileHandler.get() instanceof CSVHandler);
    }

    @Test
    public void testCreateFileHandlerJSON() {
        Optional<FileHandler> fileHandler = FileHandlerFactory.createFileHandler(FileExtensionType.JSON.getType());

        Assert.assertTrue(fileHandler.isPresent());
        Assert.assertTrue(fileHandler.get() instanceof JsonHandler);
    }

    @Test
    public void testCreateFileHandlerXML() {
        Optional<FileHandler> fileHandler = FileHandlerFactory.createFileHandler(FileExtensionType.XML.getType());

        Assert.assertTrue(fileHandler.isPresent());
        Assert.assertTrue(fileHandler.get() instanceof XMLHandler);
    }

    @Test
    public void testCreateFileHandlerUnknown() {
        Optional<FileHandler> fileHandler = FileHandlerFactory.createFileHandler("random");

        Assert.assertFalse(fileHandler.isPresent());
    }

}