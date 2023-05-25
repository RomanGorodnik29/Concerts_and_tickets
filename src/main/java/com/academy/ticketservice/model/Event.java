package com.academy.ticketservice.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "events")
@Accessors(chain = true)
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dates")
    private Date date;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Integer price;

    @Column(name = "age_limit")
    private Short ageLimit;

    @Column(name = "continuance")
    private Time continuance;

    @Column(name = "descriptions")
    private String description;

    @Column(name = "occupied_places")
    private Short occupiedPlace;

    @ToString.Exclude
    @OneToMany(mappedBy = "eventHolding",
            fetch = FetchType.LAZY)
    private Set<Ticket> tickets;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = { CascadeType.MERGE, CascadeType.DETACH })
    @JoinColumn(name = "artists_id")
    private Artist eventOrganizer;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locations_id")
    private Location location;

}