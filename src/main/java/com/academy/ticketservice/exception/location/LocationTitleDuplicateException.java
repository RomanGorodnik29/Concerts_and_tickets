package com.academy.ticketservice.exception.location;

public class LocationTitleDuplicateException extends RuntimeException {

    public LocationTitleDuplicateException(String errorMessage) {
        super(errorMessage);
    }

}
