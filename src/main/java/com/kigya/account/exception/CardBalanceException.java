package com.kigya.account.exception;

@SuppressWarnings("unused")
public final class CardBalanceException extends Exception {

    public CardBalanceException() {
        super();
    }

    public CardBalanceException(String message) {
        super(message);
    }

    public CardBalanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CardBalanceException(Throwable cause) {
        super(cause);
    }

    public CardBalanceException(String message, Throwable cause,
                                boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
