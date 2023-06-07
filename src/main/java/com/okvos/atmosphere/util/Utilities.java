package com.okvos.atmosphere.util;

import com.okvos.atmosphere.common.exceptions.ValidationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.regex.Pattern;

public class Utilities {

    private static final int USERNAME_MAX_CHAR = 25;
    private static final int USERNAME_MIN_CHAR = 2;
    private static final String USERNAME_REGEX = "^[A-Za-z0-9]+(?:[ ;\\*\\.!_-][A-Za-z0-9!\\.\\*]+)*$";

    private static final int PASSWORD_MIN_CHAR = 6;

    private static final int EMAIL_MIN_CHAR = 6;
    private static final int EMAIL_MAX_CHAR = 255;
    private static final String EMAIL_REGEX = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$";

    public static void validateUsername(String username) throws ValidationException {
        if (USERNAME_MIN_CHAR > username.length() || USERNAME_MAX_CHAR < username.length()) {
            throw new ValidationException("Username too long or short");
        }

        if (!Pattern.matches(USERNAME_REGEX, username)) {
            throw new ValidationException("Username format invalid");
        }
    }

    public static void validateEmailAddress(String emailAddress) throws ValidationException {
        if (EMAIL_MIN_CHAR > emailAddress.length() || EMAIL_MAX_CHAR < emailAddress.length()) {
            throw new ValidationException("Email too long or short");
        }

        if (!Pattern.matches(EMAIL_REGEX, emailAddress)) {
            throw new ValidationException("Email format invalid");
        }
    }

    public static String encodePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static boolean comparePassword(String rawPassword, String encodedPassword) {
        return new BCryptPasswordEncoder().matches(rawPassword, encodedPassword);
    }

}
