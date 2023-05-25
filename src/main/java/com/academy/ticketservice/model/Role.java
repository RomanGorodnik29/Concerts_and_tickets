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
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name")
    private String name;

    @ToString.Exclude
    @ManyToMany(mappedBy = "roles",
            fetch = FetchType.LAZY)
    private Set<Credential> credentials;

}
