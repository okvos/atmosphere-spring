package com.okvos.atmosphere.authenticate.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

public class RegistrationRequest {

    @NotBlank @Getter @Setter
    private String username;

    @NotBlank @Getter @Setter
    private String password;

    @NotBlank @Getter @Setter @Email
    private String emailAddress;

}
