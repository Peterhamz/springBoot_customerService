package com.example.Springbootexample.exception;

import com.example.Springbootexample.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@ResponseStatus()
public class GlobalExceptionHandler extends
        ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerNotFound.class)
    public ResponseEntity<ErrorMessage> customerNotFound(CustomerNotFound exception, WebRequest webRequest){


        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,
                exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
