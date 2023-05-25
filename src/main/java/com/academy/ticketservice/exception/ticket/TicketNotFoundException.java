package com.academy.ticketservice.exception.ticket;

public class TicketNotFoundException extends RuntimeException {

    public TicketNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
