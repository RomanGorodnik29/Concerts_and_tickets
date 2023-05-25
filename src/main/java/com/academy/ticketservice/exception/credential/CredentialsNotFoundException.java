package com.academy.ticketservice.exception.credential;

public class CredentialsNotFoundException extends RuntimeException {

    public CredentialsNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
