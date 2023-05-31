package com.okvos.atmosphere;


import lombok.Getter;
import lombok.Setter;

public class ErrorResponse {

    public boolean success = false;

    @Getter @Setter
    public Integer errorCode;

    @Getter @Setter
    public String message;

}
