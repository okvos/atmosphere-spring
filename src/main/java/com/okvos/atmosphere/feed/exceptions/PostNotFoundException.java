package com.okvos.atmosphere.feed.exceptions;

public class PostNotFoundException extends Exception {
    public PostNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
