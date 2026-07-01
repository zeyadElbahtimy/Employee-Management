package com.myFullstackZeyad.employee_management.shared;

import com.myFullstackZeyad.employee_management.shared.GlobalResponse.ErrorItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;

@ControllerAdvice // annotation for error handling
public class GlobalExceptionResponse {

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<GlobalResponse<?>> handleNoResourceFoundException(NoResourceFoundException ex) {
        var errors = List.of(new ErrorItem("The requested URL was not found."));
        return new ResponseEntity<>(new GlobalResponse<>(errors), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomResponceException.class)
    public ResponseEntity<GlobalResponse<?>> handleCustomFoundException(CustomResponceException ex) {
        var errors = List.of(new ErrorItem(ex.getMessage()));
        return new ResponseEntity<>(new GlobalResponse<>(errors), HttpStatus.resolve(ex.getCode()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<GlobalResponse<?>> handleTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        String message = String.format("Parameter '%s' should be of type %s", ex.getName(),
                ex.getRequiredType() != null ? ex.getRequiredType().getSimpleName() : "unknown");
        var errors = List.of(new ErrorItem(message));
        return new ResponseEntity<>(new GlobalResponse<>(errors), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GlobalResponse<?>> handleValidationException(MethodArgumentNotValidException ex) {
        var errors = ex.getBindingResult().getFieldErrors().stream()
                .map(err -> new ErrorItem(err.getField() + " " + err.getDefaultMessage())).toList();
        return new ResponseEntity<>(new GlobalResponse<>(errors), HttpStatus.BAD_REQUEST);
    }
}
