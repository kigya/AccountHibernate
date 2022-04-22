package com.kigya.account.exception;

public final class RepositoryException extends Exception {
    public RepositoryException(Exception e, String log) {
        super(log, e);
    }
}
