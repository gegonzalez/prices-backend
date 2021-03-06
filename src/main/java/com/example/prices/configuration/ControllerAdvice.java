package com.example.prices.configuration;

import com.example.prices.configuration.domain.ErrorResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerAdvice {

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception) {
    return getErrorResponseResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException exception) {
    return getErrorResponseResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ServletRequestBindingException.class)
  public ResponseEntity<ErrorResponse> handleServletRequestBindingException(ServletRequestBindingException exception) {
    return getErrorResponseResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(NoSuchElementException.class)
  public ResponseEntity<ErrorResponse> handleException(NoSuchElementException exception) {
    return getErrorResponseResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleException(Exception exception) {
    return getErrorResponseResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
  }

  private ResponseEntity<ErrorResponse> getErrorResponseResponseEntity(String message, HttpStatus httpStatus) {
    return ResponseEntity.status(httpStatus)
            .body(
                    ErrorResponse.builder()
                            .status(httpStatus)
                            .code(String.valueOf(httpStatus.value()))
                            .message(message)
                            .build());
  }
}
