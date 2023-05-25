package com.academy.ticketservice.service;

import com.academy.ticketservice.dto.LocationModelDto;
import com.academy.ticketservice.dto.RequestStatusDto;
import com.academy.ticketservice.dto.UpdateLocationInformationRequestDto;

public interface LocationServiceInterface {

    RequestStatusDto deleteLocationById(Long locationId);

    LocationModelDto getLocationByIdOrTitle(String idOrTitle);

    RequestStatusDto createLocation(LocationModelDto locationModelDto);

    RequestStatusDto updateAdditionalLocationInformation(Long locationId,
                                                         UpdateLocationInformationRequestDto updateRequest);

}
