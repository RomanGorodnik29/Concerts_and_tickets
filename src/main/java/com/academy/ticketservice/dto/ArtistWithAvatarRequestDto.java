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
public class ArtistWithAvatarRequestDto {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "nickname")
    private String nickname;

    @JsonProperty(value = "avatar")
    private String avatar;

}
