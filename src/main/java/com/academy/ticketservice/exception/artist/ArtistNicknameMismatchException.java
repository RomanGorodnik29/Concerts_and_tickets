package com.academy.ticketservice.exception.artist;

public class ArtistNicknameMismatchException extends RuntimeException {

    public ArtistNicknameMismatchException(String errorMessage) {
        super(errorMessage);
    }

}
