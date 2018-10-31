package com.andreyplis.purchasesbackendjava.security.controller;

public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
