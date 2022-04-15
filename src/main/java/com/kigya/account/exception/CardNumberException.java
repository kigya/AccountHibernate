package com.kigya.account.exception;

public final class CardNumberException extends Exception {

    public CardNumberException() {
        super();
    }

    public CardNumberException(String message) {
        super(message);
    }

    public CardNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public CardNumberException(Throwable cause) {
        super(cause);
    }

    public CardNumberException(String message, Throwable cause,
                               boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
