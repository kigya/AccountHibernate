package com.kigya.account.exception;

public final class AccountPasswordException extends Exception {

    public AccountPasswordException() {
        super();
    }

    public AccountPasswordException(String message) {
        super(message);
    }

    public AccountPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountPasswordException(Throwable cause) {
        super(cause);
    }

    public AccountPasswordException(String message, Throwable cause,
                                    boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
