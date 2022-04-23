package com.kigya.account.exception;

@SuppressWarnings("unused")
public final class AccountGenderException extends Exception {

    public AccountGenderException() {
        super();
    }

    public AccountGenderException(String message) {
        super(message);
    }

    public AccountGenderException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountGenderException(Throwable cause) {
        super(cause);
    }

    public AccountGenderException(String message, Throwable cause,
                                  boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
