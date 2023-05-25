package com.academy.ticketservice.repository;

import com.academy.ticketservice.model.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LocationRepository extends CrudRepository<Location, Long> {

    Boolean existsByTitle(String title);

    Optional<Location> getLocationById(Long id);

    Optional<Location> getLocationByTitle(String title);

}
