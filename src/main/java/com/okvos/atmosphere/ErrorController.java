package com.okvos.atmosphere;

import com.okvos.atmosphere.common.exceptions.ValidationException;
import com.okvos.atmosphere.user.exceptions.UsernameTakenException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.okvos.atmosphere.user.exceptions.InvalidCredentialsException;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ErrorController {

    private static final Logger LOG = LoggerFactory.getLogger(ErrorController.class);

    public static Integer ERROR_UNAUTHORIZED = 1;
    public static Integer ERROR_MALFORMED_REQUEST = 2;
    public static Integer ERROR_USERNAME_TAKEN = 3;

    @ExceptionHandler(InvalidCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse handle(InvalidCredentialsException ex) {
        LOG.error("Invalid Credentials Exception", ex);

        ErrorResponse err = new ErrorResponse();
        err.setErrorCode(ERROR_UNAUTHORIZED);
        err.setMessage("Invalid credentials");

        return err;

    }

    @ExceptionHandler(UsernameTakenException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handle(UsernameTakenException ex) {
        LOG.error("Username taken Exception", ex);

        ErrorResponse err = new ErrorResponse();
        err.setErrorCode(ERROR_USERNAME_TAKEN);
        err.setMessage("Username taken");

        return err;

    }

    @ExceptionHandler({org.springframework.web.bind.MethodArgumentNotValidException.class, ValidationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handle(Exception ex) {
        LOG.error("Bad Request Exception", ex);

        ErrorResponse err = new ErrorResponse();
        err.setErrorCode(ERROR_MALFORMED_REQUEST);
        err.setMessage("Invalid request");

        return err;

    }

}
