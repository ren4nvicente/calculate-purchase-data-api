package com.globalblue.purchases;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;


@RestController
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = {BindException.class})
    @ResponseBody
    public ResponseEntity<?> handleExecption(BindException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(exception.getAllErrors().stream()
                        .map(e -> e.getDefaultMessage())
                        .collect(Collectors.toList()));
    }
}
