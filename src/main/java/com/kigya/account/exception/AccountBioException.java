package com.kigya.account.exception;

@SuppressWarnings("unused")
public final class AccountBioException extends Exception {

    public AccountBioException() {
        super();
    }

    public AccountBioException(String message) {
        super(message);
    }

    public AccountBioException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountBioException(Throwable cause) {
        super(cause);
    }

    public AccountBioException(String message, Throwable cause,
                               boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
