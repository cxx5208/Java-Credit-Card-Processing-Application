package com.sjsu.assignment;

import com.sjsu.assignment.card.context.CreditCardContext;

public class CreditCardClient {

    public static void main(String[] args) {
        CreditCardContext creditCardContext = new CreditCardContext();

        String inputBaseDir = "src/main/resources/input/";
        String outputBaseDir = "src/main/resources/output/";

        String csvInputFilename = inputBaseDir + "input_file.csv";
        String csvOutputFilename = outputBaseDir + "output_file.csv";
        creditCardContext.process(csvInputFilename, csvOutputFilename);

        String jsonInputFilename = inputBaseDir + "input_file.json";
        String jsonOutputFilename = outputBaseDir + "output_file.json";
        creditCardContext.process(jsonInputFilename, jsonOutputFilename);

        String xmlInputFilename = inputBaseDir + "input_file.xml";
        String xmlOutputFilename = outputBaseDir + "output_file.xml";
        creditCardContext.process(xmlInputFilename, xmlOutputFilename);
    }
}
