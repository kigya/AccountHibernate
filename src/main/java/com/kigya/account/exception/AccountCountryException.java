package com.kigya.account.exception;

@SuppressWarnings("unused")
public final class AccountCountryException extends Exception {

    public AccountCountryException() {
        super();
    }

    public AccountCountryException(String message) {
        super(message);
    }

    public AccountCountryException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountCountryException(Throwable cause) {
        super(cause);
    }

    public AccountCountryException(String message, Throwable cause,
                                   boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
