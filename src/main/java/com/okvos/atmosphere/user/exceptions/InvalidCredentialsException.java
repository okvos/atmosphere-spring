package com.okvos.atmosphere.user.exceptions;

public class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException(String errorMessage) {
        super(errorMessage);
    }
}
