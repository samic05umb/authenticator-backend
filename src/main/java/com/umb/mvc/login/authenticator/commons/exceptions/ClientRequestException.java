package com.umb.mvc.login.authenticator.commons.exceptions;

public class ClientRequestException extends Exception {
    public ClientRequestException() {
    }

    public ClientRequestException(String message) {
        super(message);
    }

    public ClientRequestException(String message, Throwable t) {
        super(message, t);
    }
}
