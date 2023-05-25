package com.academy.ticketservice.repository;

import com.academy.ticketservice.model.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends CrudRepository<Event, Long> {

    @Query(value = "select * from events",
        nativeQuery = true)
    Optional<List<Event>> getAll();

    @Query(value = "select * from events order by RAND() limit 3",
        nativeQuery = true)
    Optional<List<Event>> getTopSixEvents();

    Boolean existsByTitle(String title);

    Optional<List<Event>> getAllByLocation_Id(Long id);

    Optional<Event> getEventByTitleContains(String title);

    Optional<List<Event>> getAllByEventOrganizer_Id(Long id);

    Optional<List<Event>> getAllByLocation_Title(String title);

    Optional<List<Event>> getAllByEventOrganizer_Nickname(String nickname);

}
