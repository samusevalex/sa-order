package ru.iteco.saorder.service.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleOrderBusinessException(EntityNotFoundException exception) {
        ExceptionDto exceptionDto = new ExceptionDto()
                .setUuid(UUID.randomUUID())
                .setMessage(exception.getMessage());
        return ResponseEntity
                .internalServerError()
                .body(exceptionDto);

    }
}
