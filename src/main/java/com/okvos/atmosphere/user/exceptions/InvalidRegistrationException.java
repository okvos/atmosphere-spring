package com.okvos.atmosphere.user.exceptions;

public class InvalidRegistrationException extends Exception {
    public InvalidRegistrationException(String errorMessage) {
        super(errorMessage);
    }
}
