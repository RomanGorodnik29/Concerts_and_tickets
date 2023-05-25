package com.academy.ticketservice.service;

import com.academy.ticketservice.dto.CreateEventRequestDto;
import com.academy.ticketservice.dto.EventModelDto;
import com.academy.ticketservice.dto.RequestStatusDto;

import java.util.List;

public interface EventServiceInterface {

    List<EventModelDto> getAllEvents();

    List<EventModelDto> getTopSixEvents();

    EventModelDto getEventById(Long eventId);

    RequestStatusDto deleteEvent(Long eventId);

    EventModelDto getEventByTitleContains(String eventTitle);

    List<EventModelDto> getEventsByLocationIdOrTitle(String idOrTitle);

    List<EventModelDto> getEventsByArtistIdOrNickname(String idOrNickname);

    RequestStatusDto createAnEvent(CreateEventRequestDto createEventRequest);

}
