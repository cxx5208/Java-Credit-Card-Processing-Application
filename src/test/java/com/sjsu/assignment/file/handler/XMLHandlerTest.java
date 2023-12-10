package com.sjsu.assignment.file.handler;

import com.sjsu.assignment.card.models.CreditCardDetailsInput;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;

public class XMLHandlerTest {

    @Test
    public void testParseFile() {
        XMLHandler xmlHandler = new XMLHandler();
        List<CreditCardDetailsInput> creditCardDetailsInputList = xmlHandler.parseFile("src/test/resources/input_file.xml");
        Assert.assertTrue(CollectionUtils.isNotEmpty(creditCardDetailsInputList));
        Assert.assertEquals(12, creditCardDetailsInputList.size());
    }

}
