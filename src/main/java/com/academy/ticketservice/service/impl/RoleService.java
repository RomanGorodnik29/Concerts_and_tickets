package com.academy.ticketservice.service.impl;

import com.academy.ticketservice.dto.RequestStatusDto;
import com.academy.ticketservice.dto.UserRoleManipulationRequestDto;
import com.academy.ticketservice.exception.credential.CredentialsNotFoundException;
import com.academy.ticketservice.exception.role.RoleNotFoundException;
import com.academy.ticketservice.model.Credential;
import com.academy.ticketservice.model.Role;
import com.academy.ticketservice.repository.CredentialRepository;
import com.academy.ticketservice.repository.RoleRepository;
import com.academy.ticketservice.service.RoleServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
@RequiredArgsConstructor
public class RoleService implements RoleServiceInterface {

    private final RoleRepository roleRepository;

    private final CredentialRepository credentialRepository;

    @Override
    public RequestStatusDto assigningRoleToUser(UserRoleManipulationRequestDto grantRoleToUserRequest) {

        Role currentRoleToGrant = roleRepository.findByName(grantRoleToUserRequest.getRole())
                .orElseThrow(() -> new RoleNotFoundException("Role not found"));

        Credential currentUser = credentialRepository.findByEmail(grantRoleToUserRequest.getUserEmail())
                .orElseThrow(() -> new CredentialsNotFoundException("User not found"));

        if (currentUser.getRoles().stream()
                .anyMatch(role -> role.getName().equals(currentRoleToGrant.getName())))
            throw new RoleNotFoundException("This user already has such role");

        currentUser.getRoles().add(currentRoleToGrant);

        credentialRepository.save(currentUser);

        return new RequestStatusDto()
                .setStatusId(HttpStatus.OK.value())
                .setTimespan(Calendar.getInstance().getTime().toString())
                .setMessage("Selected role successfully granted");
    }

    @Override
    public RequestStatusDto demoteRoleFromUser(UserRoleManipulationRequestDto demoteRoleFromUserRequest) {

        Role currentRoleToGrant = roleRepository.findByName(demoteRoleFromUserRequest.getRole())
                .orElseThrow(() -> new RoleNotFoundException("Role not found"));

        Credential currentUser = credentialRepository.findByEmail(demoteRoleFromUserRequest.getUserEmail())
                .orElseThrow(() -> new CredentialsNotFoundException("User not found"));

        if (currentUser.getRoles().stream()
                .anyMatch(role -> role.getName().equals(currentRoleToGrant.getName())))
            throw new RoleNotFoundException("This user did not own current role");

        currentUser.getRoles().remove(currentRoleToGrant);

        return new RequestStatusDto()
                .setStatusId(HttpStatus.OK.value())
                .setTimespan(Calendar.getInstance().getTime().toString())
                .setMessage("Selected role successfully demote");
    }

}
