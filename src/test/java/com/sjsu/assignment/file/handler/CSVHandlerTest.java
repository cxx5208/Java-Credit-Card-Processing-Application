package com.sjsu.assignment.file.handler;

import com.sjsu.assignment.card.models.CreditCardDetailsInput;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;

public class CSVHandlerTest {

    @Test
    public void testParseFile() {
        CSVHandler csvHandler = new CSVHandler();
        List<CreditCardDetailsInput> creditCardDetailsInputList = csvHandler.parseFile("src/test/resources/input_file.csv");
        Assert.assertTrue(CollectionUtils.isNotEmpty(creditCardDetailsInputList));
        Assert.assertEquals(12, creditCardDetailsInputList.size());
    }
}