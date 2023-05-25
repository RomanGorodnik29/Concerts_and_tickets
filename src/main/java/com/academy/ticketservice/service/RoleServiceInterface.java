package com.academy.ticketservice.service;

import com.academy.ticketservice.dto.RequestStatusDto;
import com.academy.ticketservice.dto.UserRoleManipulationRequestDto;

public interface RoleServiceInterface {

    RequestStatusDto assigningRoleToUser(UserRoleManipulationRequestDto grantRoleToUserRequest);

    RequestStatusDto demoteRoleFromUser(UserRoleManipulationRequestDto demoteRoleFromUserRequest);

}
