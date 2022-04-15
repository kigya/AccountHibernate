package com.kigya.account.exception;

public final class AccountUsernameException extends Exception {

    public AccountUsernameException() {
        super();
    }

    public AccountUsernameException(String message) {
        super(message);
    }

    public AccountUsernameException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountUsernameException(Throwable cause) {
        super(cause);
    }

    public AccountUsernameException(String message, Throwable cause,
                                    boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
