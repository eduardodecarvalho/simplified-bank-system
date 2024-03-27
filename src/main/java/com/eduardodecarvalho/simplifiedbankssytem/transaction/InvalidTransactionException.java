package com.eduardodecarvalho.simplifiedbankssytem.transaction;

public class InvalidTransactionException extends RuntimeException {

    public InvalidTransactionException(String message) {
        super(message);
    }

}
