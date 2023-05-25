package com.academy.ticketservice.service;

import com.academy.ticketservice.dto.TicketModelDto;
import com.academy.ticketservice.dto.TicketOrderDto;

import java.util.List;

public interface TicketServiceInterface {

    TicketModelDto getTicketById(Long id);

    List<TicketModelDto> getAllTicketsByUserId(Long userId);

    List<TicketModelDto> getAllTicketsByEventId(Long eventId);

    TicketModelDto orderAnTicket(TicketOrderDto ticketOrderDto);

}
