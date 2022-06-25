package com.jramos.petshopcoreservices.exceptions;

import com.jramos.petshopcoreservices.Models.GeneralResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,HttpStatus status, WebRequest request) {
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



    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handle(Exception ex, HttpServletRequest request, HttpServletResponse response) {

        logger.info("handle");
        var customResponse =  new GeneralResponseModel();
        customResponse.setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        customResponse.setStatus(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        customResponse.setId(UUID.randomUUID().toString());
        customResponse.setPath(request.getRequestURI());
        customResponse.setMessage(ex.getMessage());
        customResponse.setTimeStamp(LocalDateTime.now());
        if( ex instanceof  GeneralResponseException){
            return new ResponseEntity<>(customResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(customResponse);
    }
}
