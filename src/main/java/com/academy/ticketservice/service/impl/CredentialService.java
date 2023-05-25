package com.academy.ticketservice.service.impl;

import com.academy.ticketservice.dto.CredentialModelDto;
import com.academy.ticketservice.dto.DeleteAccountRequestDto;
import com.academy.ticketservice.dto.RequestStatusDto;
import com.academy.ticketservice.exception.credential.CredentialWithSameDataAlreadyExistsException;
import com.academy.ticketservice.exception.credential.CredentialsNotFoundException;
import com.academy.ticketservice.exception.role.RoleNotFoundException;
import com.academy.ticketservice.exception.user.UserDataMismatchException;
import com.academy.ticketservice.model.Credential;
import com.academy.ticketservice.model.Role;
import com.academy.ticketservice.model.User;
import com.academy.ticketservice.repository.CredentialRepository;
import com.academy.ticketservice.repository.RoleRepository;
import com.academy.ticketservice.util.mapper.MapperInterface;
import com.academy.ticketservice.service.CredentialServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class CredentialService implements CredentialServiceInterface {

    private final RoleRepository roleRepository;

    private final CredentialRepository credentialRepository;

    private final MapperInterface<CredentialModelDto, Credential> mapper;

    @Override
    public RequestStatusDto registeredAnAccount(CredentialModelDto registrationRequest) {
        if (credentialRepository.existsByEmail(registrationRequest.getEmail()))
            throw new CredentialWithSameDataAlreadyExistsException("Account with same email already exists");

        Role roleToGrant = roleRepository.findByName("USER")
                .orElseThrow(() -> new RoleNotFoundException("Internal server error"));

        Credential currentCredential = mapper.mapToEntity(registrationRequest, Credential.class);

        currentCredential.setRoles(new HashSet<>(){{ add(roleToGrant); }})
                .setUser(new User().setCredential(currentCredential).setPhoneNumber(""));

        credentialRepository.save(currentCredential);

        return new RequestStatusDto()
                .setStatusId(HttpStatus.OK.value())
                .setTimespan(Calendar.getInstance().getTime().toString())
                .setMessage("Account successfully created. You can login by your credentials.");
    }

    @Override
    public RequestStatusDto deleteAccount(DeleteAccountRequestDto deleteAccountRequest) {
        if (!deleteAccountRequest.getEmail().equals(deleteAccountRequest.getEmailConfirmation()))
            throw new UserDataMismatchException("Email mismatch");

        Credential currentCredential = credentialRepository.findByEmail(deleteAccountRequest.getEmail())
                .orElseThrow(() -> new CredentialsNotFoundException("User not found"));

        credentialRepository.delete(currentCredential);

        return new RequestStatusDto()
                .setStatusId(HttpStatus.OK.value())
                .setTimespan(Calendar.getInstance().getTime().toString())
                .setMessage("Account successfully deleted");
    }
}
