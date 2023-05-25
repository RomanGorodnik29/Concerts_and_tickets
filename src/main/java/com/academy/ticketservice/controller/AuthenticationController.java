package com.academy.ticketservice.controller;

import com.academy.ticketservice.dto.CredentialModelDto;
import com.academy.ticketservice.dto.RequestStatusDto;
import com.academy.ticketservice.service.CredentialServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class AuthenticationController {

    private final CredentialServiceInterface credentialService;

    @GetMapping("auth")
    public String getLoginPage() {

        return "user/login-page.html";
    }

    @GetMapping("reg")
    public String getRegistrationPage(Model model) {
        model.addAttribute("credentialModel", CredentialModelDto.builder().build());

        return "user/registration.html";
    }

    @PostMapping("account")
    public String createAnNewAccount(Model model,
                                     @ModelAttribute CredentialModelDto credentialModel) {

        RequestStatusDto statusDto = credentialService.registeredAnAccount(credentialModel);
        model.addAttribute("status", statusDto);

        return "success.html";
    }

}
