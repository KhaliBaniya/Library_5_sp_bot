package com.example.controller;

import com.example.exp.AppBadRequestException;
import com.example.exp.PhoneAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.Column;

@ControllerAdvice
public class AdviceController {
    @ExceptionHandler({AppBadRequestException.class,PhoneAlreadyExistsException.class})
    public ResponseEntity<String> handleException(AppBadRequestException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

//    @ExceptionHandler(PhoneAlreadyExistsException.class)
//    public ResponseEntity<String> handleException(PhoneAlreadyExistsException e){
//        return ResponseEntity.badRequest().body(e.getMessage());
//    }
}
