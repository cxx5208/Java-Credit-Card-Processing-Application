package com.sjsu.assignment.card.context;

import com.sjsu.assignment.card.models.CreditCardDetailsOutput;
import com.sjsu.assignment.card.utils.CreditCardUtils;
import com.sjsu.assignment.file.constants.FileExtensionType;
import com.sjsu.assignment.card.models.CreditCardDetailsInput;
import com.sjsu.assignment.file.factory.FileHandlerFactory;
import com.sjsu.assignment.file.handler.FileHandler;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.commons.io.FilenameUtils;

public class CreditCardContext {

    public void process(String inputFileName, String outputFileName) {

        String inputFileNameExtension = FilenameUtils.getExtension(inputFileName);
        String outPutFileNameExtension = FilenameUtils.getExtension(outputFileName);

        if(!inputFileNameExtension.equalsIgnoreCase(outPutFileNameExtension)) {
            throw new RuntimeException("Input and output files should have the same extension");
        }

        Optional<FileHandler> fileHandlerOptional = FileHandlerFactory.createFileHandler(inputFileNameExtension);

        if( !fileHandlerOptional.isPresent()) {
            throw new RuntimeException("File type is not Supported. Supported File Types are : " + Arrays.toString(FileExtensionType.values()));
        }

        FileHandler fileHandler = fileHandlerOptional.get();

        List<CreditCardDetailsInput> creditCardDetailsInputList = fileHandler.parseFile(inputFileName);

        List<CreditCardDetailsOutput> creditCardDetailsOutputList = creditCardDetailsInputList
            .stream()
            .map(CreditCardUtils::computeCreditCardDetails)
            .collect(Collectors.toList());

        fileHandler.writeContentsToFile(creditCardDetailsOutputList, outputFileName);

    }

}
