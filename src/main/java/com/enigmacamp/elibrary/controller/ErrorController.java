package com.enigmacamp.elibrary.controller;

import com.enigmacamp.elibrary.exception.EntityExistException;
import com.enigmacamp.elibrary.exception.NotFoundException;
import com.enigmacamp.elibrary.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(EntityExistException.class)
    ResponseEntity<ErrorResponse> handleEntityViolationException(EntityExistException exception){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ErrorResponse("X03", exception.getMessage()));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDataNotFoundException(NotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("X01", exception.getMessage()));
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> handleAllExecption(Exception exception){
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse("X06", exception.getMessage()));
//    }
}
