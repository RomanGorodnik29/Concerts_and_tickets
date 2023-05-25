package com.academy.ticketservice.service;

import com.academy.ticketservice.dto.RequestStatusDto;
import com.academy.ticketservice.dto.UpdateUserAdditionalInfoRequestDto;
import com.academy.ticketservice.dto.UpdateUserPhoneNumberRequestDto;
import com.academy.ticketservice.dto.UserModelDto;

public interface UserServiceInterface {

    UserModelDto getUserByPhoneNumberOrId(String getUserByPhoneNumberOrIdRequestString);

    RequestStatusDto updateUserAdditionalInfo(UpdateUserAdditionalInfoRequestDto updateUserRequest);

    RequestStatusDto updateUserPhoneNumber(UpdateUserPhoneNumberRequestDto updateUserPhoneNumberRequest);

}
