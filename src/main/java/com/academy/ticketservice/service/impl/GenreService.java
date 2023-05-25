package com.academy.ticketservice.service.impl;

import com.academy.ticketservice.repository.GenreRepository;
import com.academy.ticketservice.service.GenreServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreService implements GenreServiceInterface {

    private final GenreRepository genreRepository;

}
