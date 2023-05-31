package com.okvos.atmosphere.user.exceptions;

public class UsernameTakenException extends Exception {
    public UsernameTakenException(String errorMessage) {
        super(errorMessage);
    }
}
