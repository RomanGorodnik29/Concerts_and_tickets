package com.academy.ticketservice.exception.event;

public class EventNotFoundException extends RuntimeException {

    // Event not found Runtime Exception
    public EventNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
