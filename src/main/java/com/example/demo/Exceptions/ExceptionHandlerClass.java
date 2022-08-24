package com.example.demo.Exceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@Slf4j
@ControllerAdvice
public class ExceptionHandlerClass {

    @ExceptionHandler(EmptyListCheckException.class)
    public ResponseEntity<String> handleListCheck(EmptyListCheckException emptyListCheckException){
        log.error(" Empty List Check Exception occurred: " , emptyListCheckException);
        return new ResponseEntity<>("No entry found", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidAgeException.class)
    public ResponseEntity<String> handleAgeValidation(InvalidAgeException invalidAgeException){
        log.error(" Invalid age Exception occurred: " , invalidAgeException);
        return new ResponseEntity<>("Age not valid", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception exception){
        log.error(" Some Exception occurred: " , exception);
        return new ResponseEntity<>("Unknown Error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
