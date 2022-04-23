package com.kigya.account.exception;

@SuppressWarnings("unused")
public final class CardTypeException extends Exception {

    public CardTypeException() {
        super();
    }

    public CardTypeException(String message) {
        super(message);
    }

    public CardTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CardTypeException(Throwable cause) {
        super(cause);
    }

    public CardTypeException(String message, Throwable cause,
                             boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
