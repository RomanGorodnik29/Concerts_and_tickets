package com.academy.ticketservice.repository;

import com.academy.ticketservice.model.Artist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends CrudRepository<Artist, Long> {

    @Query(value = "select * from artists",
            nativeQuery = true)
    Optional<List<Artist>> getAll();

    @Query(value = "select * from artists order by RAND() limit 3",
            nativeQuery = true)
    Optional<List<Artist>> getTopThree();

    Optional<Artist> getArtistByNickname(String nickname);

    @Query(value = "select a.id, a.nickname, a.users_id from artists a " +
            "left join events e " +
            "on e.artists_id = a.id " +
            "where e.id = :event_id " +
            "limit 1",
            nativeQuery = true)
    Optional<Artist> getArtistByEventId(@Param("event_id") Long eventId);

    @Query(value = "select a.id, a.nickname, a.users_id from events e " +
            "left join artists a " +
            "on e.artists_id = a.id " +
            "where e.title like :event_title " +
            "limit 1",
            nativeQuery = true)
    Optional<Artist> getArtistByEventTitle(@Param("event_title") String eventTitle);

}
