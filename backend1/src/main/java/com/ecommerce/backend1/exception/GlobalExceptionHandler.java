package com.ecommerce.backend1.exception;

import com.ecommerce.backend1.dto.ApiResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ApiResponse<String> handleError(RuntimeException ex){
        return new ApiResponse<>(ex.getMessage(),null);
    }
}
