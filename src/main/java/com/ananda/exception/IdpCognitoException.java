package com.ananda.exception;

public final class IdpCognitoException extends RuntimeException {

    public IdpCognitoException() {
        super();
    }

    public IdpCognitoException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public IdpCognitoException(final String message) {
        super(message);
    }

    public IdpCognitoException(final Throwable cause) {
        super(cause);
    }

}
