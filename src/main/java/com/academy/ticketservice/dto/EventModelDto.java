package com.academy.ticketservice.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class EventModelDto {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "ageLimit")
    private Integer ageLimit;

    @JsonProperty(value = "occupiedPlace")
    private Integer occupiedPlace;

    @JsonProperty(value = "date")
    private Date date;

    @JsonProperty(value = "continuance")
    private Time continuance;

    @JsonProperty(value = "price")
    private Double price;

    @JsonProperty(value = "eventOrganizer")
    private ArtistModelDto eventOrganizer;

    @JsonProperty(value = "location")
    private LocationModelDto location;

}
