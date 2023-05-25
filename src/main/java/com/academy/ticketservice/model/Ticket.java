package com.academy.ticketservice.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tickets")
@Accessors(chain = true)
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "qr_code")
    private String qrCode;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = { CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.DETACH })


    @JoinColumn(name = "event_id")
    private Event eventHolding;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = { CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.DETACH })
    @JoinColumn(name = "user_id")
    private User owner;

}
