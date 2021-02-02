package com.tenta.tentaserver.exception;

public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -6692714216339598080L;

    public UserNotFoundException(String username) {
        super(String.format("%s not found", username));
    }
}
