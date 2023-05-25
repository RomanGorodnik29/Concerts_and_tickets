package com.academy.ticketservice.exception.artist;

public class ArtistNotFoundException extends RuntimeException {

    public ArtistNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
