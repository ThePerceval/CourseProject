package ru.vsu.csf.alcomanager.exception;

public class ApiUnauthorizedException extends RuntimeException{
    public ApiUnauthorizedException(String message) {
        super(message);
    }

    public ApiUnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }
}
