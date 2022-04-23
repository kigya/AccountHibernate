package com.kigya.account.exception;

@SuppressWarnings("unused")
public final class AccountStreetAddressException extends Exception {

    public AccountStreetAddressException() {
        super();
    }

    public AccountStreetAddressException(String message) {
        super(message);
    }

    public AccountStreetAddressException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountStreetAddressException(Throwable cause) {
        super(cause);
    }

    public AccountStreetAddressException(String message, Throwable cause,
                                         boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
