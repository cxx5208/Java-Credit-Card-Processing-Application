package com.sjsu.assignment.file.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sjsu.assignment.card.models.CreditCardDetailsInput;
import com.sjsu.assignment.card.models.CreditCardDetailsOutput;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonHandler implements FileHandler {

    @Override
    public List<CreditCardDetailsInput> parseFile(String inputFilename) {

        List<CreditCardDetailsInput> result = new ArrayList<>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            result = Arrays.asList(mapper.readValue(new File(inputFilename), CreditCardDetailsInput[].class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public void writeContentsToFile(List<CreditCardDetailsOutput> creditCardDetailsOutput,
        String outputFileName) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            mapper.writeValue(new File(outputFileName), creditCardDetailsOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
