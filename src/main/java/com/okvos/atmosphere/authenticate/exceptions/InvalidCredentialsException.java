package com.okvos.atmosphere.authenticate.exceptions;

public class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException(String errorMessage) {
        super(errorMessage);
    }
}
