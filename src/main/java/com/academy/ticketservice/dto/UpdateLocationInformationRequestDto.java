package com.academy.ticketservice.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UpdateLocationInformationRequestDto {

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "address")
    private String address;

    @JsonProperty(value = "capacity")
    private Integer capacity;

}
