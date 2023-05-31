package com.okvos.atmosphere.user.domain;

import lombok.Getter;
import lombok.Setter;

public class RegistrationResponse {

    @Getter @Setter
    private String username;

    @Getter @Setter
    private Integer userId;

}
