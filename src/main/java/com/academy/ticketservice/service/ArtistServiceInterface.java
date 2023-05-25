package com.academy.ticketservice.service;

import com.academy.ticketservice.dto.ArtistModelDto;
import com.academy.ticketservice.dto.ChangeArtistNicknameRequestDto;
import com.academy.ticketservice.dto.DeleteArtistCardRequestDto;
import com.academy.ticketservice.dto.RequestStatusDto;

import java.util.List;

public interface ArtistServiceInterface {

    List<ArtistModelDto> getTopThree();

    List<ArtistModelDto> getAllArtists();

    ArtistModelDto getArtistById(Long artistId);

    RequestStatusDto registerAnArtistCard(String email, ArtistModelDto artistModelDto);

    ArtistModelDto getArtistByEventIdOrTitle(String getArtistByEventIdOrTitleDto);

    RequestStatusDto deleteAnArtistCard(DeleteArtistCardRequestDto deleteArtistCardRequest);

    RequestStatusDto changeArtistNickname(ChangeArtistNicknameRequestDto changeArtistNicknameRequest);

}
