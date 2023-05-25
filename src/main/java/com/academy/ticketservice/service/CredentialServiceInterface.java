package com.academy.ticketservice.service;

import com.academy.ticketservice.dto.CredentialModelDto;
import com.academy.ticketservice.dto.DeleteAccountRequestDto;
import com.academy.ticketservice.dto.RequestStatusDto;

public interface CredentialServiceInterface {

    RequestStatusDto registeredAnAccount(CredentialModelDto registrationRequest);

    RequestStatusDto deleteAccount(DeleteAccountRequestDto deleteAccountRequest);

}
