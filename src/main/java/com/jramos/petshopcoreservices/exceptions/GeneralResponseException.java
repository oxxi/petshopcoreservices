package com.jramos.petshopcoreservices.exceptions;

public class GeneralResponseException extends RuntimeException{

    public GeneralResponseException() {
        super();
    }

    public GeneralResponseException(String message) {
        super(message);
    }

    public GeneralResponseException(String message, Throwable cause) {
        super(message, cause);
    }
}
