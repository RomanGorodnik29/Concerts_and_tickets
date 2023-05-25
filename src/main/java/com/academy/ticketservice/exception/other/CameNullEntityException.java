package com.academy.ticketservice.exception.other;

public class CameNullEntityException extends RuntimeException {

    public CameNullEntityException(String errorMessage) {
        super(errorMessage);
    }

}
