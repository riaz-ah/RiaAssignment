package com.example.demo.booking.advice;


import com.example.demo.booking.EmptyListCheckException;
import com.example.demo.booking.InvalidAgeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {
    @ExceptionHandler(EmptyListCheckException.class)
    public ResponseEntity<String> handleListCheck(EmptyListCheckException emptyListCheckException){
        return new ResponseEntity<>("No entry found", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidAgeException.class)
    public ResponseEntity<String> handleAgeValidation(InvalidAgeException invalidAgeException){
        return new ResponseEntity<>("Age not valid", HttpStatus.BAD_REQUEST);
    }
}
