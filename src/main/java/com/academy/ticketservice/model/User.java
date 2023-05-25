package com.academy.ticketservice.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @ToString.Exclude
    @OneToMany(mappedBy = "cardOwner")
    private Set<Artist> artistCard;

    @ToString.Exclude
    @OneToMany(mappedBy = "owner")
    private Set<Ticket> tickets;

    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "credentials_id")
    private Credential credential;

}
