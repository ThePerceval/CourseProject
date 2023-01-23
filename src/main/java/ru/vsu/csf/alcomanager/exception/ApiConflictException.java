package ru.vsu.csf.alcomanager.exception;

public class ApiConflictException extends RuntimeException{
    public ApiConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiConflictException(String message) {
        super(message);
    }
}
