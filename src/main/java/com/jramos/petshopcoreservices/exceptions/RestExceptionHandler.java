package com.jramos.petshopcoreservices.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        Map<String, String> body = new HashMap<>();
         ex.getBindingResult().getFieldErrors().forEach(error -> {
             body.put(error.getField(),error.getDefaultMessage());
         });
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Required request body is missing");

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
