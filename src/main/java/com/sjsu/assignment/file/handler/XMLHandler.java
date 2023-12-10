package com.sjsu.assignment.file.handler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sjsu.assignment.card.models.CreditCardDetailsInput;
import com.sjsu.assignment.card.models.CreditCardDetailsOutput;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLHandler implements FileHandler {

    @Override
    public List<CreditCardDetailsInput> parseFile(String inputFilename) {
        List<CreditCardDetailsInput> result = new ArrayList<>();

        try {
            ObjectMapper mapper = new XmlMapper();
            result = mapper.readValue(new File(inputFilename), new TypeReference<List<CreditCardDetailsInput>>(){});
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public void writeContentsToFile(List<CreditCardDetailsOutput> creditCardDetailsOutput,
        String outputFileName) {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        try {
            dBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document document = dBuilder.newDocument();

        // Create the Root
        Element root = document.createElement("CARDS");
        document.appendChild(root);

        for(CreditCardDetailsOutput output : creditCardDetailsOutput) {

            Element row = document.createElement("CARD");
            root.appendChild(row);

            Element cardNumber = document.createElement("CARD_NUMBER");
            cardNumber.appendChild(document.createTextNode(output.getCardNumber()));
            row.appendChild(cardNumber);

            Element cardType = document.createElement("CARD_TYPE");
            cardType.appendChild(document.createTextNode(output.getCardType()));
            row.appendChild(cardType);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        document.setXmlStandalone(true);
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File(outputFileName));

        try {
            transformer.transform(domSource, streamResult);
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }

}
