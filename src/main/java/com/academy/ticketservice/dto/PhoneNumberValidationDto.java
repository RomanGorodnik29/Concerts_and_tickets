package com.academy.ticketservice.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
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
public class PhoneNumberValidationDto {

    private String phone;

    private boolean valid;

    private Format FormatObject;

    private Country CountryObject;

    private String location;

    private String type;

    private String carrier;

}
