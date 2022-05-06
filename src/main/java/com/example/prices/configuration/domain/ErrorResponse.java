package com.example.prices.configuration.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Builder
@ToString
@Getter
public class ErrorResponse {
  @Builder.Default private LocalDateTime timestamp = LocalDateTime.now();
  private HttpStatus status;
  private String code;
  private String message;
}
