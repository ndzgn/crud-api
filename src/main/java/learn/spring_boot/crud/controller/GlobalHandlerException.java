package learn.spring_boot.crud.controller;

import learn.spring_boot.crud.common.ApiError;
import learn.spring_boot.crud.exception.ProductAllReadyExistsException;
import learn.spring_boot.crud.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity handleProductNotFoundException(ProductNotFoundException exception){
        ApiError apiError = new ApiError(exception.getMessage());
        return new ResponseEntity(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductAllReadyExistsException.class)
    public ResponseEntity handleProductAllReadyExistsException(ProductAllReadyExistsException exception)
    {
        ApiError apiError = new ApiError(exception.getMessage());
        return new ResponseEntity(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException exception)
    {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        ApiError error = ApiError.builder()
                .timestamp(LocalDateTime.now())
                .status(400)
                .message(errors)
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
