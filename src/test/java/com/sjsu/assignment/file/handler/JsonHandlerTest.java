package com.sjsu.assignment.file.handler;

import com.sjsu.assignment.card.models.CreditCardDetailsInput;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;

public class JsonHandlerTest  {

    @Test
    public void testParseFile() {
        JsonHandler jsonHandler = new JsonHandler();
        List<CreditCardDetailsInput> creditCardDetailsInputList = jsonHandler.parseFile("src/test/resources/input_file.json");
        Assert.assertTrue(CollectionUtils.isNotEmpty(creditCardDetailsInputList));
        Assert.assertEquals(12, creditCardDetailsInputList.size());
    }
}