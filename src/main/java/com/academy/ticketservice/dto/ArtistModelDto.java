package com.academy.ticketservice.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ArtistModelDto {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "nickname")
    private String nickname;

    @JsonProperty(value = "avatar")
    private String avatar;

    @JsonProperty(value = "shortQuote")
    private String shortQuote;

    @JsonProperty(value = "longQuote")
    private String longQuote;

    @JsonProperty(value = "events")
    private List<EventModelDto> events;

}