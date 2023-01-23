package ru.vsu.csf.alcomanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = ApiBadRequestException.class)
    public ResponseEntity<Object> handleApiBadRequestException(ApiBadRequestException e){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ApiExceptionDto apiExceptionDto = new ApiExceptionDto(e.getMessage(), httpStatus, LocalDateTime.now());
        return new ResponseEntity<>(apiExceptionDto, httpStatus);
    }

    @ExceptionHandler(value = ApiNotFoundException.class)
    public ResponseEntity<Object> handleApiNotFoundException(ApiNotFoundException e){
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ApiExceptionDto apiExceptionDto = new ApiExceptionDto(e.getMessage(), httpStatus, LocalDateTime.now());
        return new ResponseEntity<>(apiExceptionDto, httpStatus);
    }

    @ExceptionHandler(value = ApiConflictException.class)
    public ResponseEntity<Object> handleApiConflictException(ApiConflictException e){
        HttpStatus httpStatus = HttpStatus.CONFLICT;
        ApiExceptionDto apiExceptionDto = new ApiExceptionDto(e.getMessage(), httpStatus, LocalDateTime.now());
        return new ResponseEntity<>(apiExceptionDto, httpStatus);
    }

    @ExceptionHandler(value = ApiUnauthorizedException.class)
    public ResponseEntity<Object> handleApiUnauthorizedException(ApiUnauthorizedException e){
        HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
        ApiExceptionDto apiExceptionDto = new ApiExceptionDto(e.getMessage(), httpStatus, LocalDateTime.now());
        return new ResponseEntity<>(apiExceptionDto, httpStatus);
    }
}
