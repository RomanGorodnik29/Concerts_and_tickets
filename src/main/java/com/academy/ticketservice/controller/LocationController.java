package com.academy.ticketservice.controller;

import com.academy.ticketservice.service.LocationServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/location")
@RequiredArgsConstructor
public class LocationController {

    private final LocationServiceInterface locationService;

}
