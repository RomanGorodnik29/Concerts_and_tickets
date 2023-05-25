package com.academy.ticketservice.repository;

import com.academy.ticketservice.model.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {
}
