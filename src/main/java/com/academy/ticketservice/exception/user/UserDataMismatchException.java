package com.academy.ticketservice.exception.user;

public class UserDataMismatchException extends RuntimeException {

    public UserDataMismatchException(String errorMessage) {
        super(errorMessage);
    }

}
