package com.sjsu.assignment.file.factory;

import com.sjsu.assignment.file.constants.FileExtensionType;
import com.sjsu.assignment.file.handler.CSVHandler;
import com.sjsu.assignment.file.handler.FileHandler;
import com.sjsu.assignment.file.handler.JsonHandler;
import com.sjsu.assignment.file.handler.XMLHandler;
import java.util.Optional;

public class FileHandlerFactory {

    public static Optional<FileHandler> createFileHandler(String fileTypeExtension) {
        if(fileTypeExtension.equalsIgnoreCase(FileExtensionType.CSV.name())) {
            return Optional.of(new CSVHandler());
        } else if (fileTypeExtension.equalsIgnoreCase(FileExtensionType.JSON.name())) {
            return Optional.of(new JsonHandler());
        } else if (fileTypeExtension.equalsIgnoreCase(FileExtensionType.XML.name())) {
            return Optional.of(new XMLHandler());
        } else {
            return Optional.empty();
        }
    }

}
