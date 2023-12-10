package com.sjsu.assignment.card.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardDetailsInput {

    @JacksonXmlProperty(localName = "CARD_NUMBER")
    private String cardNumber;
    @JacksonXmlProperty(localName = "EXPIRATION_DATE")
    private String expirationDate;
    @JacksonXmlProperty(localName = "CARD_HOLDER_NAME")
    private String cardHolderName;

}
