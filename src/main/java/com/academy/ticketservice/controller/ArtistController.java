package com.academy.ticketservice.controller;

import com.academy.ticketservice.dto.ArtistModelDto;
import com.academy.ticketservice.dto.ChangeArtistNicknameRequestDto;
import com.academy.ticketservice.dto.DeleteArtistCardRequestDto;
import com.academy.ticketservice.dto.RequestStatusDto;
import com.academy.ticketservice.service.ArtistServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("artists")
@RequiredArgsConstructor
public class ArtistController {

    private final ArtistServiceInterface artistService;

    @GetMapping("{artistId}")
    public String getArtistById(Model model,
                                @PathVariable Long artistId) {
        ArtistModelDto artistModel =
                artistService.getArtistById(artistId);

        model.addAttribute("artist", artistModel);

        return "artists/artist-card.html";
    }

    @PostMapping()
    public String createArtistCard(Model model,
                                   @RequestBody ArtistModelDto artistModelDto) {
        RequestStatusDto statusDto =
                artistService.registerAnArtistCard("some@mail.ru", artistModelDto);

        model.addAttribute("status", statusDto);

        return null;
    }

    @PutMapping()
    public String changeArtistNickname(Model model,
                                       @RequestBody ChangeArtistNicknameRequestDto changeArtistNicknameRequest) {
        RequestStatusDto statusDto =
                artistService.changeArtistNickname(changeArtistNicknameRequest);

        model.addAttribute("status", statusDto);

        return null;
    }

    @DeleteMapping()
    public String deleteArtistCard(Model model,
                                   @RequestBody DeleteArtistCardRequestDto deleteArtistCardRequest) {
        RequestStatusDto statusDto =
                artistService.deleteAnArtistCard(deleteArtistCardRequest);

        model.addAttribute("status", statusDto);

        return null;
    }

    @GetMapping()
    public String getAllArtists(Model model) {
        model.addAttribute("artists",
                artistService.getAllArtists());

        return "artists/artists.html";
    }

    @GetMapping("by-event/{idOrTitle}")
    public String getArtistByEventIdOrTitle(Model model,
                                       @PathVariable String idOrTitle) {
        ArtistModelDto artistModelDto =
                artistService.getArtistByEventIdOrTitle(idOrTitle);

        model.addAttribute("artistCard", artistModelDto);

        return null;
    }
}
