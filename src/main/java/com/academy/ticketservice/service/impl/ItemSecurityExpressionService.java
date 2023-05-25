package com.academy.ticketservice.service.impl;

import com.academy.ticketservice.repository.ArtistRepository;
import com.academy.ticketservice.repository.CredentialRepository;
import com.academy.ticketservice.repository.EventRepository;
import com.academy.ticketservice.repository.TicketRepository;
import com.academy.ticketservice.service.ItemSecurityExpressionServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemSecurityExpressionService implements ItemSecurityExpressionServiceInterface {

    private final EventRepository eventRepository;

    private final TicketRepository ticketRepository;

    private final ArtistRepository artistRepository;

    private final CredentialRepository credentialRepository;

}
