package com.kigya.account.exception;

public final class AccounBiolException extends Exception {

    public AccounBiolException() {
        super();
    }

    public AccounBiolException(String message) {
        super(message);
    }

    public AccounBiolException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccounBiolException(Throwable cause) {
        super(cause);
    }

    public AccounBiolException(String message, Throwable cause,
                               boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
