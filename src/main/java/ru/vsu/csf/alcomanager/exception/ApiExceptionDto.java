package ru.vsu.csf.alcomanager.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ApiExceptionDto(String message, HttpStatus httpStatus, LocalDateTime time) {
}
