package com.academy.ticketservice.exception.location;

public class LocationNotFoundException extends RuntimeException {

    public LocationNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
