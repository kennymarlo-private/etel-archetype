package com.etel.advice;

import com.etel.exception.TokenNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestController
@ControllerAdvice
public class CustomErrorHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleAllExceptions(Exception e, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity usernameNotFoundException(UsernameNotFoundException e, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TokenNotFoundException.class)
    public ResponseEntity tokenNotFoundException(TokenNotFoundException e, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }
}
