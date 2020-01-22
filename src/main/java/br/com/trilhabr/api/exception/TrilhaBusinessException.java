package br.com.trilhabr.api.exception;

public class TrilhaBusinessException extends RuntimeException {

    public TrilhaBusinessException(String messageException) {
        super(messageException);
    }
}
