package com.example.prices.configuration;

import com.example.prices.configuration.domain.ErrorResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class ControllerAdvice {

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception) {
    return getExceptionDetailResponseEntity(exception.getMessage());
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException exception) {

    return getExceptionDetailResponseEntity(exception.getMessage());
  }

  @ExceptionHandler(ServletRequestBindingException.class)
  public ResponseEntity<ErrorResponse> handleServletRequestBindingException(ServletRequestBindingException exception) {
    return getExceptionDetailResponseEntity(exception.getMessage());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleException(Exception exception) {
    return getExceptionDetailResponseEntity(exception.getMessage());
  }

  private ResponseEntity<ErrorResponse> getExceptionDetailResponseEntity(String message) {
    HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    return ResponseEntity.status(httpStatus)
        .body(
            ErrorResponse.builder()
                .status(httpStatus)
                .code(String.valueOf(httpStatus.value()))
                .message(message)
                .build());
  }
}
