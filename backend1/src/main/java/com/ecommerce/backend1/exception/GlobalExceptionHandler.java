package com.ecommerce.backend1.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public String handleException(RuntimeException ex){
        return ex.getMessage();
    }
}
