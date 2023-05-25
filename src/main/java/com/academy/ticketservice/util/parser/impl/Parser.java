package com.academy.ticketservice.util.parser.impl;

import com.academy.ticketservice.util.parser.ParserInterface;
import org.springframework.stereotype.Component;

@Component
public class Parser implements ParserInterface {

    @Override
    public Boolean isInputStringAnId(String inputString) {
        try {
            Long.parseLong(inputString);

            return true;
        } catch (NumberFormatException numberFormatException) {

            return false;
        }
    }

}
