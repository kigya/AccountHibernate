package com.kigya.account.exception;

@SuppressWarnings("unused")
public final class AccountEmailException extends Exception {

    public AccountEmailException() {
        super();
    }

    public AccountEmailException(String message) {
        super(message);
    }

    public AccountEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountEmailException(Throwable cause) {
        super(cause);
    }

    public AccountEmailException(String message, Throwable cause,
                                 boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
