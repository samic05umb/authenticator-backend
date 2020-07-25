package com.umb.mvc.login.authenticator.commons.exceptions;

public class ApplicationException extends Exception {
    public ApplicationException() {
    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable t) {
        super(message, t);
    }
}
