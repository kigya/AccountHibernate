package com.kigya.account.exception;

@SuppressWarnings("unused")
public final class AccountCityException extends Exception {

    public AccountCityException() {
        super();
    }

    public AccountCityException(String message) {
        super(message);
    }

    public AccountCityException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountCityException(Throwable cause) {
        super(cause);
    }

    public AccountCityException(String message, Throwable cause,
                                boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
