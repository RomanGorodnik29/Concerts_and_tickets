package com.academy.ticketservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "address")
    private String address;

    @Column(name = "capacity")
    private Integer capacity;

    @ToString.Exclude
    @OneToMany(mappedBy = "location",
            fetch = FetchType.LAZY)
    private Set<Event> events;

}

