package com.academy.ticketservice.exception.event;

public class EventTitleDuplicateException extends RuntimeException {

    public EventTitleDuplicateException(String errorMessage) {
        super(errorMessage);
    }

}
