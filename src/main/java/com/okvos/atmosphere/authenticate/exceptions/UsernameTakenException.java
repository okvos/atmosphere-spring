package com.okvos.atmosphere.authenticate.exceptions;

public class UsernameTakenException extends Exception {
    public UsernameTakenException(String errorMessage) {
        super(errorMessage);
    }
}
