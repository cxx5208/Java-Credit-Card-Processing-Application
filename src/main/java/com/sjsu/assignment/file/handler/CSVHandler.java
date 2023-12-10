package com.sjsu.assignment.file.handler;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.opencsv.CSVWriter;
import com.sjsu.assignment.card.models.CreditCardDetailsInput;
import com.sjsu.assignment.card.models.CreditCardDetailsOutput;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVHandler implements FileHandler {

    @Override
    public List<CreditCardDetailsInput> parseFile(String inputFilename) {
        List<CreditCardDetailsInput> result = new ArrayList<>();
        try {
            CsvSchema schema = CsvSchema.emptySchema().withHeader();
            MappingIterator<CreditCardDetailsInput> personsIterator = new CsvMapper()
                .readerFor(CreditCardDetailsInput.class)
                .with(schema)
                .readValues(new File(inputFilename));

            result = personsIterator.readAll();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;

    }

    @Override
    public void writeContentsToFile(List<CreditCardDetailsOutput> creditCardDetailsOutput,
        String outputFileName) {

        // default separator is a comma
        try (CSVWriter writer = new CSVWriter(new FileWriter(outputFileName))) {
            writer.writeAll(getTotalData(creditCardDetailsOutput));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static List<String[]> getTotalData(
        List<CreditCardDetailsOutput> creditCardDetailsOutput) {
        List<String[]> result = new ArrayList<>();
        String[] header = {"cardNumber", "cardType"};
        result.add(header);

        for (CreditCardDetailsOutput output : creditCardDetailsOutput) {
            String[] temp = {output.getCardNumber(), output.getCardType()};
            result.add(temp);
        }

        return result;
    }

}
