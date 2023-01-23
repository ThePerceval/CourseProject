package ru.vsu.csf.alcomanager.exception;

public class ApiBadRequestException extends RuntimeException{

    public ApiBadRequestException(String message) {
        super(message);
    }

    public ApiBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
