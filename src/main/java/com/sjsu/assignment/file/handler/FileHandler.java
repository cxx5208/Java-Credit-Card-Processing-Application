package com.sjsu.assignment.file.handler;

import com.sjsu.assignment.card.models.CreditCardDetailsInput;
import com.sjsu.assignment.card.models.CreditCardDetailsOutput;
import java.util.List;

public interface FileHandler {

    List<CreditCardDetailsInput> parseFile(String inputFilename);

    void writeContentsToFile(List<CreditCardDetailsOutput> creditCardDetailsOutput, String outputFileName);

}
