package com.academy.ticketservice.exception.credential;

public class CredentialWithSameDataAlreadyExistsException extends RuntimeException {

    public CredentialWithSameDataAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }

}
