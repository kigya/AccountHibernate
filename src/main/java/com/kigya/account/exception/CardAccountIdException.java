package com.kigya.account.exception;

public final class CardAccountIdException extends Exception {

    public CardAccountIdException() {
        super();
    }

    public CardAccountIdException(String message) {
        super(message);
    }

    public CardAccountIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public CardAccountIdException(Throwable cause) {
        super(cause);
    }

    public CardAccountIdException(String message, Throwable cause,
                                  boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
